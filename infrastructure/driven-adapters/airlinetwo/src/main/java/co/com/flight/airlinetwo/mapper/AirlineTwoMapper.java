package co.com.flight.airlinetwo.mapper;

import co.com.flight.airlinetwo.request.AirlineTwoRequest;
import co.com.flight.airlinetwo.response.AirlineTwoResponse;
import co.com.flight.model.flight.Flight;
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

    public static Flight createFlightFromResponse(AirlineTwoResponse response) {
        return Flight.builder()
                .airline(response.getCarrier())
                .price(response.getBasePrice().add(response.getTax()))
                .departureAirportCode(response.getDepartureAirportName())
                .destinationAirportCode(response.getArrivalAirportName())
                .build();
    }
}
