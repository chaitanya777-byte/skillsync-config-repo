package com.skillsync.chat_service.DTO;

import lombok.Data;

@Data
public class ChatMessageDTO {
    private String senderId;
    private String receiverId;
    private String content;
    private String projectId;
}
