package com.airlinemanagementsystem.controller;

import com.airlinemanagementsystem.entity.Flight;
import com.airlinemanagementsystem.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    private final FlightService flightService;

    @PostMapping("/create-flight")
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight){
        return ResponseEntity.status(HttpStatus.OK).body(flightService.createFlight(flight));

    }
}
