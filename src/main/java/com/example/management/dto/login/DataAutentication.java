package com.example.management.dto.login;

import jakarta.validation.constraints.NotBlank;

public record DataAutentication(@NotBlank  String login,
                                @NotBlank String password) {
}
