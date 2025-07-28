package com.skillsync.project_service.Controller;

import com.skillsync.project_service.DTOs.ProjectRequest;
import com.skillsync.project_service.DTOs.ProjectResponse;
import com.skillsync.project_service.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/createProject")
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest request) {
        return ResponseEntity.ok(projectService.createProject(request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ProjectResponse>> getProjectsByUser(@PathVariable String userId) {
        return ResponseEntity.ok(projectService.getProjectsByUser(userId));
    }
}

