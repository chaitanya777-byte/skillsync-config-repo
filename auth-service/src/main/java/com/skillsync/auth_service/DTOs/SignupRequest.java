package com.skillsync.auth_service.DTOs;

import com.skillsync.auth_service.Entities.Role;
import lombok.*;

@Data
public class SignupRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}
