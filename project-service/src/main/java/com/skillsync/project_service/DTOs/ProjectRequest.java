package com.skillsync.project_service.DTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjectRequest {
    private String userId;
    private String name;
    private String description;
    private String status;
    private LocalDate deadline;
}

