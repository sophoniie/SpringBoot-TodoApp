package com.example.todo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.dto.RegisterRequest;
import com.example.todo.dto.RegisterResponse;
import com.example.todo.model.User;
import com.example.todo.service.RegistrationService;

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
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        User created = registrationService.register(request.getFullName(), request.getUsername(), request.getEmail(), request.getPassword());

        RegisterResponse response = new RegisterResponse(created.getId(), created.getUsername(), created.getFullName(), created.getEmail().toString());

        return ResponseEntity.ok(response);
    }
}
