package co.com.flight.airlinetwo.client;

import co.com.flight.airlinetwo.request.AirlineTwoRequest;
import co.com.flight.airlinetwo.response.AirlineTwoResponse;

import java.util.List;

public interface IAirlineTwoClient {
    List<AirlineTwoResponse> fetchData(AirlineTwoRequest request);
}
