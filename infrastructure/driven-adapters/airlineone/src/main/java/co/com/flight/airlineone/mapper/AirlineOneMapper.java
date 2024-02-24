package co.com.flight.airlineone.mapper;

import co.com.flight.airlineone.request.AirlineOneRequest;
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
}
