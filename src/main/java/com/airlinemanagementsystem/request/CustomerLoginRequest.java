package com.airlinemanagementsystem.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
public class CustomerLoginRequest {
    @Pattern(regexp = "^(.+)@(\\S+)$", message = "Enter a valid email address")
    @NotBlank
    private String email;

    @NotBlank
    @Pattern(regexp = "^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9\\s]).{8,})",
            message = "Minimum eight characters, at least one letter in uppercase, in lowercase, one special symbol and one number")
    private String password;
}
