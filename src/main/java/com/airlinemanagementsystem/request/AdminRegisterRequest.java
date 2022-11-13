package com.airlinemanagementsystem.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminRegisterRequest extends CustomerRegisterRequest {

    private String adminCode;

}
