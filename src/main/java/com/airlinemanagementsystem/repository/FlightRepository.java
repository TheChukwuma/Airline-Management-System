package com.airlinemanagementsystem.repository;

import com.airlinemanagementsystem.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
