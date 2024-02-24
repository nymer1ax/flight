package co.com.flight.model.flight.valueobject;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SearchCriteria {
    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private int passengers;
    private String cabinClass;
    private int daysFlexibility;
    private List<String> airlines;
}
