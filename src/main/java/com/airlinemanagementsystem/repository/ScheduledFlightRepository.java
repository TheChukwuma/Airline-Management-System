package com.airlinemanagementsystem.repository;

import com.airlinemanagementsystem.entity.ScheduledFlight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduledFlightRepository extends JpaRepository<ScheduledFlight, Long> {
}
