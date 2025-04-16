package com.example.management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AddressDto(
        @NotBlank
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 12345-678") String postalCode,
        @NotBlank String street,
        @NotBlank String district,
        @NotBlank String city,
        @NotNull Integer number,
        @NotBlank String complement) {
}
