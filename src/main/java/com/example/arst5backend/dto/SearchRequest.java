package com.example.arst5backend.dto;

import com.example.arst5backend.model.Airport;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
    String departureAirport;
    String arrivalAirport;
    @JsonFormat(pattern="yyyy-MM-dd")
    Date departureDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    Date returnDate;
    int numOfFlexibleDate;
    int numOfStopover;
    boolean acceptFirstClass;
    boolean acceptEconomy;

    public SearchRequest(
            String departureAirport,
            String arrivalAirport,
            @JsonFormat(pattern="yyyy-MM-dd")
            Date departureDate
    ) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
    }

    public SearchRequest(
            String departureAirport,
            String arrivalAirport,
            @JsonFormat(pattern="yyyy-MM-dd")
            Date departureDate,
            @JsonFormat(pattern="yyyy-MM-dd")
            Date returnDate
    ) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
    }
}