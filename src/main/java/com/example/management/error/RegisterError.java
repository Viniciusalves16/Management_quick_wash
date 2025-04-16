package com.example.management.error;

import lombok.Builder;

@Builder
public class RegisterError {

    Integer code;
    String message;
}
