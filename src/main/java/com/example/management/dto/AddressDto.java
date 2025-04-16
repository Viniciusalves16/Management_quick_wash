package com.example.management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressDto(@NotBlank String code,
                         @NotBlank String street,
                         @NotBlank String district,
                         @NotBlank String city,
                         @NotNull Integer number,
                         @NotBlank String complement) {
}
