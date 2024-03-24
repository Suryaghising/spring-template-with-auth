package com.surya.quizze.modules.auth.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record LoginRequest(

        @NotNull(message = "Email is required")
                @NotEmpty(message = "Email is required")
                @Email(message = "Enter a valid email")
        String email,
        @NotNull(message = "Password is required")
        @NotEmpty(message = "Password is required")
        String password) {
}
