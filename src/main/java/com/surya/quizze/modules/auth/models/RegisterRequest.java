package com.surya.quizze.modules.auth.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record RegisterRequest(
        @NotNull(message = "First name is required")
        @NotEmpty(message = "First name is required")
        String firstName,
        @NotNull(message = "Last name is required")
        @NotEmpty(message = "Last name is required")
        String lastName,
        @NotNull(message = "Email name is required")
        @NotEmpty(message = "Email name is required")
        @Email(message = "Enter a valid email")
        String email,
        @NotNull(message = "Password name is required")
        @NotEmpty(message = "Password name is required")
        String password) {
}
