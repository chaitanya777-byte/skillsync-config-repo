package com.skillsync.user_profile_service.Service;

import com.skillsync.user_profile_service.Entity.UserProfile;
import com.skillsync.user_profile_service.Repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository repository;

    public UserProfile createUser(UserProfile profile) {
        return repository.save(profile);
    }

    public UserProfile getUserById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserProfile updateUser(String id, UserProfile updatedProfile) {
        UserProfile existing = getUserById(id);
        existing.setName(updatedProfile.getName());
        existing.setEmail(updatedProfile.getEmail());
        existing.setRole(updatedProfile.getRole());
        existing.setSkills(updatedProfile.getSkills());
        return repository.save(existing);
    }

    public void deleteUser(String id) {
        repository.deleteById(id);
    }

    public List<UserProfile> getAllUsers() {
        return repository.findAll();
    }
}
