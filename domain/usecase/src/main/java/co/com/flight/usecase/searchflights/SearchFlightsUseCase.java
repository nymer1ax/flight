package co.com.flight.usecase.searchflights;

import co.com.flight.model.flight.Flight;
import co.com.flight.model.flight.gateways.FlightRepository;
import co.com.flight.model.flight.valueobject.SearchCriteria;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SearchFlightsUseCase {

    private final List<FlightRepository> flightRepositories;
    public List<Flight> searchFlights(SearchCriteria searchCriteria){
       return flightRepositories.stream()
                .flatMap(flightRepository -> flightRepository.findFlights(searchCriteria)
                        .stream()).sorted(Comparator.comparing(Flight::getPrice)).collect(Collectors.toList());
    }
}
