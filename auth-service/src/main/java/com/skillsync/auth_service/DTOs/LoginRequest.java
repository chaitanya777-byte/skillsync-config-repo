package com.skillsync.auth_service.DTOs;


import lombok.*;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
