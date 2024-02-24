package co.com.flight.airlinetwo.mapper;

import co.com.flight.airlinetwo.request.AirlineTwoRequest;
import co.com.flight.model.flight.valueobject.SearchCriteria;

public class AirlineTwoMapper {
    private AirlineTwoMapper() {
    }
    public static AirlineTwoRequest createRequestFromCriteria(SearchCriteria criteria) {
        return AirlineTwoRequest.builder()
                .from(criteria.getOrigin())
                .to(criteria.getDestination())
                .outboundDate(criteria.getDepartureDate())
                .inboundDate(criteria.getReturnDate())
                .numberOfAdults(criteria.getPassengers())
                .build();
    }
}
