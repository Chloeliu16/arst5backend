package dto;

import com.example.arst5backend.model.Trip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponse {
    boolean isSuccess;
    //Customers will be empty
    List<Trip> potentialTrips;
}
