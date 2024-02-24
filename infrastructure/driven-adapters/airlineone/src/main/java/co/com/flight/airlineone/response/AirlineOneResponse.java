package co.com.flight.airlineone.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AirlineOneResponse {
    private String airline;
    private BigDecimal price;
    private String cabinClass;
    private String departureAirportCode;
    private String destinationAirportCode;
    private LocalDateTime departureDate;
}
