package com.airlinemanagementsystem.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminRegisterRequest extends CustomerRegisterRequest {

    private String adminCode;

}
