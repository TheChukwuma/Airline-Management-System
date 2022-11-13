package com.airlinemanagementsystem.serviceImpl;

import com.airlinemanagementsystem.entity.Customer;
import com.airlinemanagementsystem.entity.User;
import com.airlinemanagementsystem.enums.Role;
import com.airlinemanagementsystem.exception.UserAlreadyExistsException;
import com.airlinemanagementsystem.repository.CustomerRepository;
import com.airlinemanagementsystem.repository.UserRepository;
import com.airlinemanagementsystem.request.CustomerRegisterRequest;
import com.airlinemanagementsystem.response.CustomerRegisterResponse;
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

   // private final PasswordEncoder passwordEncoder;

    @Override
    public CustomerRegisterResponse registerUser(CustomerRegisterRequest request){

        Optional<User> registeredUser = userRepository.findUserByEmail(request.getEmail());

       if(registeredUser.isEmpty()){
//           User user = User.builder()
//                   .email(request.getEmail())
//                   .firstName(request.getFirstName())
//                   .lastName(request.getLastName())
//                   .phoneNumber(request.getPhoneNumber())
////               .password(passwordEncoder.encode(request.getPassword()))
//                   .password(request.getPassword())
//                   .role(Role.CUSTOMER)
//                   .build();
//           userRepository.save(user);
           Customer customer = new Customer(request);

          customerRepository.save(customer);

           return new CustomerRegisterResponse(HttpStatus.CREATED, LocalDateTime.now());
       }else {
           throw new UserAlreadyExistsException("Email account already exists!");
       }
    }

}
