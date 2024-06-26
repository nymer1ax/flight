package co.com.flight.model.flight.valueobject;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SearchCriteria {
    private String origin;
    private String destination;
    private LocalDateTime departureDate;
    private LocalDateTime returnDate;
    private int passengers;
    private String cabinClass;
    private int daysFlexibility;
    private List<String> airlines;
}
