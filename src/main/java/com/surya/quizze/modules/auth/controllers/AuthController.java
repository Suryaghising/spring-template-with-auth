package com.surya.quizze.modules.auth.controllers;

import com.surya.quizze.modules.auth.models.AuthResponse;
import com.surya.quizze.modules.auth.services.AuthService;
import com.surya.quizze.modules.auth.models.LoginRequest;
import com.surya.quizze.modules.auth.models.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerUser(
            @RequestBody @Valid RegisterRequest registerRequest
    ) {
        return ResponseEntity.ok(authService.registerUser(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUser(
            @RequestBody @Valid LoginRequest loginRequest
    ) {
        return ResponseEntity.ok(authService.loginUser(loginRequest));
    }

}
