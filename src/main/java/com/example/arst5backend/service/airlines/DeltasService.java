package com.example.arst5backend.service.airlines;

import com.example.arst5backend.model.airlines.Deltas;
import com.example.arst5backend.repository.airlines.DeltasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class DeltasService {
    private final DeltasRepository deltasRepository;

    @Autowired
    public DeltasService(DeltasRepository deltasRepository) {
        this.deltasRepository = deltasRepository;
    }

    public List<Deltas> searchDeltas(
            String DepartAirport,
            String ArriveAirport,
            // Inclusive
            Timestamp MinDepartDateTime,
            // Exclusive
            Timestamp MaxDepartDateTime
    ) {
        return deltasRepository.findByDepartairportAndArriveairportAndDepartdatetimeGreaterThanEqualAndDepartdatetimeLessThan(
                DepartAirport,
                ArriveAirport,
                MinDepartDateTime,
                MaxDepartDateTime
        );
    }
}