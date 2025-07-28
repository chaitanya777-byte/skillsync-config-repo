package com.skillsync.user_profile_service.Controller;

import com.skillsync.user_profile_service.Entity.UserProfile;
import com.skillsync.user_profile_service.Service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService service;

    @PostMapping("/create")
    public ResponseEntity<UserProfile> createUser(@RequestBody UserProfile profile) {
        return ResponseEntity.ok(service.createUser(profile));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> updateUser(@PathVariable String id, @RequestBody UserProfile profile) {
        return ResponseEntity.ok(service.updateUser(id, profile));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        service.deleteUser(id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserProfile>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }
}
