package co.com.flight.api;
import co.com.flight.model.flight.Flight;
import co.com.flight.usecase.searchflights.SearchFlightsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final SearchFlightsUseCase searchFlightsUseCase;
    @GetMapping(path = "/flight", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Flight>> search() {
        return ResponseEntity.ok(searchFlightsUseCase.searchFlights(null));
    }
}
