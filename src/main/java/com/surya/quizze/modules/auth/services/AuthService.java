package com.surya.quizze.modules.auth.services;

import com.surya.quizze.config.JwtService;
import com.surya.quizze.modules.auth.models.AuthResponse;
import com.surya.quizze.modules.auth.models.LoginRequest;
import com.surya.quizze.modules.auth.models.RegisterRequest;
import com.surya.quizze.modules.user.Role;
import com.surya.quizze.modules.user.User;
import com.surya.quizze.modules.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse registerUser(RegisterRequest registerRequest) {
        var user = User.builder()
                .firstName(registerRequest.firstName())
                .lastName(registerRequest.lastName())
                .email(registerRequest.email())
                .password(passwordEncoder.encode(registerRequest.password()))
                .role(Role.USER)
                .build();

        var savedUser = userRepository.save(user);
        String token = jwtService.generateToken(savedUser);
        return AuthResponse.builder()
                .token(token)
                .build();

    }

    public AuthResponse loginUser(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.email(),
                loginRequest.password()
        ));

        var user = userRepository.findByEmail(loginRequest.email())
                .orElseThrow();
        String token = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }
}
