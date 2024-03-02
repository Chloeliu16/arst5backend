package com.example.arst5backend.controller;

import com.example.arst5backend.dto.FlightInfo;
import com.example.arst5backend.dto.SearchRequest;
import com.example.arst5backend.dto.SearchResponse;
import com.example.arst5backend.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchFlight {
    private final SearchService searchService;

    @Autowired
    public SearchFlight(SearchService searchService){
        this.searchService = searchService;
    }

    @GetMapping
    public SearchResponse search(@RequestBody SearchRequest searchRequest) {
        System.out.println(searchRequest);
        List<FlightInfo> allDepartureFlights = searchService.searchFlights(
                searchRequest.getDepartureAirport(),
                searchRequest.getArrivalAirport(),
                searchRequest.getDepartureDate()
        );
        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setDepartureFlights(allDepartureFlights);
        if (searchRequest.getReturnDate() != null) {
            List<FlightInfo> allReturnFlights = searchService.searchFlights(
                    searchRequest.getArrivalAirport(),
                    searchRequest.getDepartureAirport(),
                    searchRequest.getReturnDate()
            );
            searchResponse.setReturnFlights(allReturnFlights);
        }
        return searchResponse;
    }
}

