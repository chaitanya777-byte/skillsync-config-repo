package com.skillsync.user_profile_service.Entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    @Id
    private String userId;

    private String name;
    private String email;
    private String role; // ADMIN, MANAGER, DEVELOPER

    @ElementCollection
    private List<String> skills = new ArrayList<>();
}
