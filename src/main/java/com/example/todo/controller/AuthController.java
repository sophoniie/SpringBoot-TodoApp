package com.example.todo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.dto.RegisterRequestDto;
import com.example.todo.dto.RegisterResponse;
import com.example.todo.model.User;
import com.example.todo.service.RegistrationService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final RegistrationService registrationService;

    public AuthController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequestDto registerRequestDto) {
        User created = registrationService.register(registerRequestDto.getFullName(), registerRequestDto.getUsername(), registerRequestDto.getEmail(), registerRequestDto.getPassword());

        RegisterResponse response = new RegisterResponse(created.getId(), created.getUsername(), created.getFullName(), created.getEmail().toString());

        return ResponseEntity.ok(response);
    }
}
