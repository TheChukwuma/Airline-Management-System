package com.airlinemanagementsystem.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminRegisterRequest extends UserRegisterRequest{

    private String adminCode;

}
