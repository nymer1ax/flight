package co.com.flight.airlineone;

import co.com.flight.model.flight.Flight;
import co.com.flight.model.flight.gateways.FlightRepository;
import co.com.flight.model.flight.valueobject.SearchCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineOneAdapter implements FlightRepository {
    @Override
    public List<Flight> findFlights(SearchCriteria searchCriteria) {
        return null;
    }
}
