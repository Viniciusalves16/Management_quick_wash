package com.example.management.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record RequestRegisterDto(
        @NotBlank @Pattern(
                regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ]+( [A-Za-zÀ-ÖØ-öø-ÿ]+)*$",
                message = "O nome deve conter apenas letras e espaços"
        ) String name,
        @NotNull Integer age,
        @NotNull @Valid AddressDto addressDto) {


}
