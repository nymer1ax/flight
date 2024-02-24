package co.com.flight.airlineone.client;

import co.com.flight.airlineone.request.AirlineOneRequest;
import co.com.flight.airlineone.response.AirlineOneResponse;

import java.util.List;

public interface IAirlineOneClient {
    List<AirlineOneResponse> fetchData(AirlineOneRequest request);
}
