package com.example.todo.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

public class UserPrincipal extends org.springframework.security.core.userdetails.User {
    private Long id;
    private String email;

    public UserPrincipal(Long id, String fullName, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
   
}