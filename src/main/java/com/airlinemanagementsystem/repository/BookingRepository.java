package com.airlinemanagementsystem.repository;

import com.airlinemanagementsystem.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
