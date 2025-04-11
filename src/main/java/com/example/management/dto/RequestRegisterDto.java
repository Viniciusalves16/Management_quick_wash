package com.example.management.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record RequestRegisterDto(@NotBlank String name, @NotNull int age, @NotNull AddressDto addressDto) {


}
