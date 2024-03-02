package com.example.arst5backend.service;

import com.example.arst5backend.dto.FlightInfo;
import com.example.arst5backend.model.Flight;
import com.example.arst5backend.model.airlines.Deltas;
import com.example.arst5backend.service.airlines.DeltasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class SearchService {

    private final DeltasService deltasService;

    @Autowired
    public SearchService(DeltasService deltasService) {
        this.deltasService = deltasService;
    }

    // Simple search flights service.
    public List<FlightInfo> searchFlights(
            String DepartAirport,
            String ArriveAirport,
            Date DepartDate
    ) {
        Timestamp departure_min_timestamp = new Timestamp(DepartDate.getTime());
        // Construct the max time stamp.
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DepartDate);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Timestamp departure_max_timestamp = new Timestamp(calendar.getTimeInMillis());
        List<Deltas> deltas = deltasService.searchDeltas(
                DepartAirport,
                ArriveAirport,
                departure_min_timestamp,
                departure_max_timestamp
        );
        List<FlightInfo> flights = new ArrayList<FlightInfo>();
        for (Deltas delta: deltas) {
            FlightInfo flight = new FlightInfo();
            flight.setArriveairport(delta.getArriveairport());
            flight.setDepartairport(delta.getDepartairport());
            flight.setDepartdatetime(delta.getDepartdatetime());
            flight.setArrivedatetime(delta.getArrivedatetime());
            flight.setFlightnumber(delta.getFlightnumber());
            flights.add(flight);
        }
        return flights;
    }

    // TODO: More complex search flights service.
    public List<Flight> searchFlights(
            String DepartAirport,
            String ArriveAirport,
            Date DepartDate,
            int NumberOfFlexibleDate,
            int NumberOfStopOver,
            Boolean AcceptFirstClass,
            Boolean AcceptEconomy
    ) {
        List<Flight> flights = new ArrayList<>();
        return flights;
    }
}
