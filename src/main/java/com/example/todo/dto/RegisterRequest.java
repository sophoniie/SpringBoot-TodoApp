package com.example.todo.dto;

public class RegisterRequest {
    private String username;
    private String fullName;
    private String email;
    private String password;

    public RegisterRequest() { }

    public String getUsername() { return this.username; }
    public void setUsername(String username) { this.username = username; }

    public String getFullName() { return this.fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return this.password; }
    public void setPassword(String password) { this.password = password; }
}
