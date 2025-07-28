package com.skillsync.auth_service.DTOs;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String token;
    private String role;
}

