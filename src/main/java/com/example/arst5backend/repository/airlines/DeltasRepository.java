package com.example.arst5backend.repository.airlines;

import com.example.arst5backend.model.airlines.Deltas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface DeltasRepository extends JpaRepository<Deltas, Long> {
    List<Deltas> findByDepartairportAndArriveairportAndDepartdatetimeGreaterThanEqualAndDepartdatetimeLessThan(
            String DepartAirport,
            String ArriveAirport,
            Timestamp MinDepartDateTime,
            Timestamp MaxDepartDateTime
    );
}