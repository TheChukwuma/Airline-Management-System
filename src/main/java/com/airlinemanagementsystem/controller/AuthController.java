package com.airlinemanagementsystem.controller;

import com.airlinemanagementsystem.exception.UnAuthorisedAdminException;
import com.airlinemanagementsystem.request.AdminRegisterRequest;
import com.airlinemanagementsystem.request.CustomerRegisterRequest;
import com.airlinemanagementsystem.response.UserRegisterResponse;
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
    public ResponseEntity<UserRegisterResponse> registerUser(@Valid @RequestBody CustomerRegisterRequest request){
        UserRegisterResponse response = authService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/admin/register")
    public ResponseEntity<UserRegisterResponse> registerAdmin(@Valid @RequestBody AdminRegisterRequest request) throws UnAuthorisedAdminException {
        UserRegisterResponse response = authService.registerAdmin(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
