package com.skillsync.task_service.Repository;

import com.skillsync.task_service.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProjectId(Long projectId);
    List<Task> findByAssignedUserId(Long userId);
}
