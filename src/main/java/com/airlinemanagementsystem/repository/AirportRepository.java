package com.airlinemanagementsystem.repository;

import com.airlinemanagementsystem.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}
