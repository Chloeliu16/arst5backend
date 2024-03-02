package com.example.arst5backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightInfo {
    Timestamp departdatetime;
    Timestamp arrivedatetime;
    String departairport;
    String arriveairport;
    String flightnumber;
}
