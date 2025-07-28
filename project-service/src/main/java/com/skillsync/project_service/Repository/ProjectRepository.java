package com.skillsync.project_service.Repository;

import com.skillsync.project_service.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByUserId(String userId);
}
