package com.skillsync.project_service.DTOs;

import lombok.Data;

import java.time.LocalDate;

import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class ProjectResponse {
    private Long id;
    private String name;
    private String description;
    private String status;
    private LocalDate createdAt;
    private LocalDate deadline;
}
