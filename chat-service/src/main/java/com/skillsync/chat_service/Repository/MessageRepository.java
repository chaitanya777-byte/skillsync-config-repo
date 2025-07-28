package com.skillsync.chat_service.Repository;

import com.skillsync.chat_service.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByProjectIdOrderByTimestampAsc(String projectId);
}

