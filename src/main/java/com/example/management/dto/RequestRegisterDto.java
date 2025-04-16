package com.example.management.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record RequestRegisterDto(@NotBlank String name,
                                 @NotNull Integer age,
                                 @NotNull @Valid AddressDto addressDto) {


}
