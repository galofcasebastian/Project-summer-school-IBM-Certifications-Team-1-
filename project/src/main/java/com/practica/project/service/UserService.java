package com.practica.project.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private String username;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}