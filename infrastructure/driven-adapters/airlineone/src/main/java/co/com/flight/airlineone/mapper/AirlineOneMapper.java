package co.com.flight.airlineone.mapper;

import co.com.flight.airlineone.request.AirlineOneRequest;
import co.com.flight.airlineone.response.AirlineOneResponse;
import co.com.flight.model.flight.Flight;
import co.com.flight.model.flight.valueobject.SearchCriteria;

public class AirlineOneMapper {
    private AirlineOneMapper() {
    }
    public static AirlineOneRequest createRequestFromCriteria(SearchCriteria criteria) {
        return AirlineOneRequest.builder()
                .origin(criteria.getOrigin())
                .destination(criteria.getDestination())
                .departureDate(criteria.getDepartureDate())
                .returnDate(criteria.getReturnDate())
                .build();
    }

    public static Flight createFlightFromResponse(AirlineOneResponse response) {
        return Flight.builder()
                .airline(response.getAirline())
                .price(response.getPrice())
                .cabinClass(response.getCabinClass())
                .departureAirportCode(response.getDepartureAirportCode())
                .destinationAirportCode(response.getDestinationAirportCode())
                .departureDateTime(response.getDepartureDate())
                .build();
    }
}
