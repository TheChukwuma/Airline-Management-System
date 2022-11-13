package com.airlinemanagementsystem.controller;

import com.airlinemanagementsystem.request.CustomerRegisterRequest;
import com.airlinemanagementsystem.response.CustomerRegisterResponse;
import com.airlinemanagementsystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/users/register")
    public ResponseEntity<CustomerRegisterResponse> registerUser(@Valid @RequestBody CustomerRegisterRequest request){
        CustomerRegisterResponse response = authService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
