package com.airlinemanagementsystem.serviceImpl;

import com.airlinemanagementsystem.entity.User;
import com.airlinemanagementsystem.enums.Role;
import com.airlinemanagementsystem.exception.UserAlreadyExistsException;
import com.airlinemanagementsystem.repository.UserRepository;
import com.airlinemanagementsystem.request.UserRegisterRequest;
import com.airlinemanagementsystem.response.UserRegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserRegisterResponse registerUser(@Valid UserRegisterRequest request){

        Optional<User> registeredUser = userRepository.findUserByEmail(request.getEmail());

       if(registeredUser.isPresent()){
           throw new UserAlreadyExistsException("Email account already exists!");
       }
       User user = User.builder()
               .email(request.getEmail())
               .firstName(request.getFirstName())
               .lastName(request.getLastName())
               .phoneNumber(request.getPhoneNumber())
               .password(passwordEncoder.encode(request.getPassword()))
               .role(Role.CUSTOMER)
               .build();
        userRepository.save(user);
        return new UserRegisterResponse(HttpStatus.CREATED, LocalDateTime.now());
    }

}
