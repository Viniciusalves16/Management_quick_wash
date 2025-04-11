package com.example.management.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RequestRegisterDto(@NotBlank String name, @NotNull BigDecimal age, @NotNull AddressDto addressDto) {


}
