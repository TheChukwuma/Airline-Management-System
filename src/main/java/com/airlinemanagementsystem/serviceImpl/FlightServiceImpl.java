package com.airlinemanagementsystem.serviceImpl;

import com.airlinemanagementsystem.entity.Flight;
import com.airlinemanagementsystem.repository.FlightRepository;
import com.airlinemanagementsystem.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Override
    public Flight createFlight(Flight flight){
        return flightRepository.save(flight);
    }
}
