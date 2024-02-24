package co.com.flight.usecase.searchflights;

import co.com.flight.model.flight.Flight;
import co.com.flight.model.flight.gateways.FlightRepository;
import co.com.flight.model.flight.valueobject.SearchCriteria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
class SearchFlightsUseCaseTest {

    @Mock
    private FlightRepository flightRepository1;

    @Mock
    private FlightRepository flightRepository2;

    private SearchFlightsUseCase searchFlightsUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        List<FlightRepository> flightRepositories = new ArrayList<>();
        flightRepositories.add(flightRepository1);
        flightRepositories.add(flightRepository2);
        searchFlightsUseCase = new SearchFlightsUseCase(flightRepositories);
    }

    @Test
    void searchFlights() {
        SearchCriteria searchCriteria = SearchCriteria.builder()
                .origin("JFK")
                .destination("LAX")
                .passengers(2)
                .build();

        List<Flight> flightsFromRepository1 = new ArrayList<>();
        flightsFromRepository1.add(Flight.builder()
                .airline("AA")
                .price(new BigDecimal("200.0"))
                .departureAirportCode("JFK")
                .destinationAirportCode("LAX")
                .build());

        List<Flight> flightsFromRepository2 = new ArrayList<>();
        flightsFromRepository2.add(Flight.builder()
                .airline("DL")
                .price(new BigDecimal("150.0"))
                .departureAirportCode("JFK")
                .destinationAirportCode("LAX")
                .build());

        when(flightRepository1.findFlights(searchCriteria)).thenReturn(flightsFromRepository1);
        when(flightRepository2.findFlights(searchCriteria)).thenReturn(flightsFromRepository2);

        List<Flight> result = searchFlightsUseCase.searchFlights(searchCriteria);

        assertEquals(2, result.size());
        assertEquals("DL", result.get(0).getAirline());
        assertEquals(new BigDecimal("150.0"), result.get(0).getPrice());
        assertEquals("AA", result.get(1).getAirline());
        assertEquals(new BigDecimal("200.0"), result.get(1).getPrice());

        verify(flightRepository1, times(1)).findFlights(searchCriteria);
        verify(flightRepository2, times(1)).findFlights(searchCriteria);
    }

}