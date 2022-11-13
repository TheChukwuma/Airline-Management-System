package com.airlinemanagementsystem.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegisterRequest {

//    @Pattern(regexp = "^[A-Za-z|\\s]*$",message = "Invalid name")
    @NotBlank
    private String firstName;

//    @Pattern(regexp = "^[A-Za-z|\\s]*$",message = "Invalid name")
    @NotBlank
    private String lastName;

//    @Pattern(regexp = "^(.+)@(\\S+)$", message = "Enter a valid email address")
    @NotBlank
    private String email;

    @NotBlank
//    @Pattern(regexp = "^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9\\s]).{8,})",
//            message = "Minimum eight characters, at least one letter in uppercase, in lowercase, one special symbol and one number")
    private String password;

    @NotBlank
//    @Pattern(regexp = "(^[0–9]{10}) | ([0–9]{10}) ")
    private String phoneNumber;

   // @NotBlank
//    @Pattern(regexp = "[\\d]{1,3}")
  //  private String countryDialCode;


}
