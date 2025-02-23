package com.example.CarAPI.payloads;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiPayload {
    private boolean success;
    private String message;
    private HttpStatus httpStatus;

    public ApiPayload(boolean success, String message, HttpStatus httpStatus) {
        this.success = success;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
