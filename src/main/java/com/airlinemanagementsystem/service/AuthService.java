package com.airlinemanagementsystem.service;

import com.airlinemanagementsystem.exception.UnAuthorisedAdminException;
import com.airlinemanagementsystem.request.AdminRegisterRequest;
import com.airlinemanagementsystem.request.CustomerRegisterRequest;
import com.airlinemanagementsystem.response.UserRegisterResponse;

public interface AuthService {

    UserRegisterResponse registerUser(CustomerRegisterRequest request);

    UserRegisterResponse registerAdmin(AdminRegisterRequest request) throws UnAuthorisedAdminException;
}
