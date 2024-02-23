package controller;

import dto.ReserveRequest;
import dto.ReserveResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserve")
public class ReserveFlight {

    @GetMapping
    public ReserveResponse reserve(@RequestBody ReserveRequest reserveRequest) {
        // Need to do the real search in database.
        ReserveResponse reserveResponse = new ReserveResponse();
        return reserveResponse;
    }
}
