package com.surya.quizze.modules.auth.models;

import lombok.Builder;

@Builder
public record AuthResponse(String token) {
}
