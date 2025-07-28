package com.skillsync.chat_service.Controller;

import com.skillsync.chat_service.DTO.ChatMessageDTO;
import com.skillsync.chat_service.Entity.Message;
import com.skillsync.chat_service.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private MessageRepository messageRepository;

    @MessageMapping("/send")
    public void handleMessage(@Payload ChatMessageDTO messageDTO) {
        Message message = Message.builder()
                .senderId(messageDTO.getSenderId())
                .receiverId(messageDTO.getReceiverId())
                .content(messageDTO.getContent())
                .timestamp(LocalDateTime.now())
                .projectId(messageDTO.getProjectId())
                .build();

        messageRepository.save(message);

        messagingTemplate.convertAndSend("/topic/project/" + messageDTO.getProjectId(), messageDTO);
    }

    @GetMapping("/messages/{projectId}")
    @ResponseBody
    public List<Message> getMessages(@PathVariable String projectId) {
        return messageRepository.findByProjectIdOrderByTimestampAsc(projectId);
    }
}
