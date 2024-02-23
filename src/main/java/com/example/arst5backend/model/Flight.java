package com.example.arst5backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    Airplane airplane;

    @OneToOne
    Seat seat;

    @OneToOne
    Airport departureAirport;

    @OneToOne
    Airport arrivalAirport;

    Time departureTime;
    Time arrivalTime;
}
