package com.example.arst5backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    @OneToOne
    Airport departureAirport;

    @OneToOne
    Airport arrivalAirport;

    boolean isRoundTrip;

    @OneToMany
    List<Ticket> tickets;

}
