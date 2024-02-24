package co.com.flight.airlinetwo.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirlineTwoResponse {
    private String carrier;
    private BigDecimal basePrice;
    private BigDecimal tax;
    private BigDecimal discount;
    private String departureAirportName;
    private String arrivalAirportName;
    private LocalDateTime outboundDateTime;
    private LocalDateTime inboundDateTime;
}
