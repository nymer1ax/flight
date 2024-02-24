package co.com.flight.airlinetwo.request;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AirlineTwoRequest {
    private String from;
    private String to;
    private LocalDateTime outboundDate;
    private LocalDateTime inboundDate;
    private Integer numberOfAdults;
}
