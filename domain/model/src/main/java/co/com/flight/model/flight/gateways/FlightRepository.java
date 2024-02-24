package co.com.flight.model.flight.gateways;

import co.com.flight.model.flight.Flight;
import co.com.flight.model.flight.valueobject.SearchCriteria;

import java.util.List;

public interface FlightRepository {
     List<Flight> findFlights(SearchCriteria searchCriteria);
}
