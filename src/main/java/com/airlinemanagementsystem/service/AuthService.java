package com.airlinemanagementsystem.service;

import com.airlinemanagementsystem.request.CustomerRegisterRequest;
import com.airlinemanagementsystem.response.CustomerRegisterResponse;

public interface AuthService {

    CustomerRegisterResponse registerUser(CustomerRegisterRequest request);
}
