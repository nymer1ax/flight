package co.com.flight.airlineone;

import co.com.flight.airlineone.client.IAirlineOneClient;
import co.com.flight.airlineone.mapper.AirlineOneMapper;
import co.com.flight.airlineone.request.AirlineOneRequest;
import co.com.flight.airlineone.response.AirlineOneResponse;
import co.com.flight.model.flight.Flight;
import co.com.flight.model.flight.gateways.FlightRepository;
import co.com.flight.model.flight.valueobject.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AirlineOneAdapter implements FlightRepository {

    private final IAirlineOneClient airlineOneClient;
    @Override
    public List<Flight> findFlights(SearchCriteria searchCriteria) {
        AirlineOneRequest request = AirlineOneMapper.createRequestFromCriteria(searchCriteria);
        List<AirlineOneResponse> response = airlineOneClient.fetchData(request);
        return  response.stream().map(AirlineOneMapper::createFlightFromResponse).collect(Collectors.toList());
    }
}
