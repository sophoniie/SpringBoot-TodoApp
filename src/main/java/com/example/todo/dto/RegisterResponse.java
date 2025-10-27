package com.example.todo.dto;

public class RegisterResponse {

    private Long id;
    private String username;
    private String email;

    public RegisterResponse(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Long getId() { return this.id; }
    public String getUsername() { return this.username; }
    public String getEmail() { return this.email; }
}
