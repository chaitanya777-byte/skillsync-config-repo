package com.skillsync.task_service.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private String status; // e.g., TODO, IN_PROGRESS, DONE

    private LocalDate dueDate;

    private String priority; // LOW, MEDIUM, HIGH

    private Long assignedUserId;  // Coming from User Service
    private Long projectId;       // Coming from Project Service
}
