package com.airlinemanagementsystem.repository;

import com.airlinemanagementsystem.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
