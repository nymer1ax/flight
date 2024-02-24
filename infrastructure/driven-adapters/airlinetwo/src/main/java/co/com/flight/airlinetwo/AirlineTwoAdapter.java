package co.com.flight.airlinetwo;

import co.com.flight.airlinetwo.client.IAirlineTwoClient;
import co.com.flight.airlinetwo.mapper.AirlineTwoMapper;
import co.com.flight.airlinetwo.request.AirlineTwoRequest;
import co.com.flight.airlinetwo.response.AirlineTwoResponse;
import co.com.flight.model.flight.Flight;
import co.com.flight.model.flight.gateways.FlightRepository;
import co.com.flight.model.flight.valueobject.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AirlineTwoAdapter implements FlightRepository {

    private final IAirlineTwoClient airlineTwoClient;
    @Override
    public List<Flight> findFlights(SearchCriteria searchCriteria) {
        AirlineTwoRequest request = AirlineTwoMapper.createRequestFromCriteria(searchCriteria);
        List<AirlineTwoResponse> response = airlineTwoClient.fetchData(request);
        return response.stream().map(AirlineTwoMapper::createFlightFromResponse).toList();
    }
}
