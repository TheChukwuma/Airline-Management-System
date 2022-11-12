package com.airlinemanagementsystem.repository;

import com.airlinemanagementsystem.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
