package com.airlinemanagementsystem.serviceImpl;

import com.airlinemanagementsystem.entity.Admin;
import com.airlinemanagementsystem.entity.Customer;
import com.airlinemanagementsystem.entity.User;
import com.airlinemanagementsystem.exception.UnAuthorisedAdminException;
import com.airlinemanagementsystem.exception.UserAlreadyExistsException;
import com.airlinemanagementsystem.repository.CustomerRepository;
import com.airlinemanagementsystem.repository.UserRepository;
import com.airlinemanagementsystem.request.AdminRegisterRequest;
import com.airlinemanagementsystem.request.CustomerRegisterRequest;
import com.airlinemanagementsystem.response.UserRegisterResponse;
import com.airlinemanagementsystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl  implements AuthService {

    private final UserRepository userRepository;

    private final CustomerRepository customerRepository;

    @Override
    public UserRegisterResponse registerUser(CustomerRegisterRequest request){

        Optional<User> registeredUser = userRepository.findUserByEmail(request.getEmail());

       if(registeredUser.isEmpty()){

           Customer customer = new Customer(request);

          customerRepository.save(customer);

           return new UserRegisterResponse(HttpStatus.CREATED, LocalDateTime.now());
       }else {
           throw new UserAlreadyExistsException("Email account already exists!");
       }
    }

    @Override
    public UserRegisterResponse registerAdmin(AdminRegisterRequest request) throws UnAuthorisedAdminException {

        Optional<User> registeredAdmin = userRepository.findUserByEmail(request.getEmail());

        if (!request.getEmail().endsWith("@naijaairway.com")){
            throw new UnAuthorisedAdminException(request.getEmail() + " is unauthorised!");
        }

        if(registeredAdmin.isEmpty()){

            Admin admin = new Admin(request);

            userRepository.save(admin);

        }else {
            throw new UserAlreadyExistsException("Email account already exists!");
        }

        return new UserRegisterResponse(HttpStatus.CREATED, LocalDateTime.now());

    }

}
