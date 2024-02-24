package co.com.flight.api;
import co.com.flight.model.flight.Flight;
import co.com.flight.model.flight.valueobject.SearchCriteria;
import co.com.flight.usecase.searchflights.SearchFlightsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final SearchFlightsUseCase searchFlightsUseCase;
    @GetMapping(path = "/flight", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Flight>> search(
            @RequestParam(required = false, name = "origin") String origin,
            @RequestParam(required = false, name = "destination") String destination,
            @RequestParam(required = false, name = "departureDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDate,
            @RequestParam(required = false, name = "returnDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime returnDate,
            @RequestParam(required = false, name = "passengers") Integer passengers,
            @RequestParam(required = false, name = "cabinClass") String cabinClass,
            @RequestParam(required = false, name = "daysFlexibility") Integer daysFlexibility,
            @RequestParam(required = false, name = "airlines") List<String> airlines
    ) {
        SearchCriteria criteria = SearchCriteria.builder()
                .origin(origin)
                .destination(destination)
                .departureDate(departureDate)
                .returnDate(returnDate)
                .passengers(passengers != null ? passengers : 0)
                .cabinClass(cabinClass)
                .daysFlexibility(daysFlexibility != null ? daysFlexibility : 0)
                .airlines(airlines)
                .build();

        return ResponseEntity.ok(searchFlightsUseCase.searchFlights(criteria));
    }
}
