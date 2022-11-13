package com.airlinemanagementsystem.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegisterResponse {

    private HttpStatus status;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime timeStamp;
}
