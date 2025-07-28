package com.skillsync.project_service.Service;

import com.skillsync.project_service.DTOs.ProjectRequest;
import com.skillsync.project_service.DTOs.ProjectResponse;
import com.skillsync.project_service.Entity.Project;
import com.skillsync.project_service.Repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectResponse createProject(ProjectRequest request) {
        Project project = new Project(
                null,
                request.getUserId(),
                request.getName(),
                request.getDescription(),
                request.getStatus(),
                LocalDate.now(),
                request.getDeadline()
        );

        projectRepository.save(project);
        return mapToResponse(project);
    }

    public List<ProjectResponse> getProjectsByUser(String userId) {
        return projectRepository.findByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private ProjectResponse mapToResponse(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStatus(),
                project.getCreatedAt(),
                project.getDeadline()
        );
    }
}
