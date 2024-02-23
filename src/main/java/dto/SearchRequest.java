package dto;

import com.example.arst5backend.model.Airport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
    Airport departureAirport;
    Airport arrivalAirport;
    Data departureData;
    int numOfFlexibleData;
    int numOfStopover;
    boolean acceptFirstClass;
    boolean acceptEconomy;
}
