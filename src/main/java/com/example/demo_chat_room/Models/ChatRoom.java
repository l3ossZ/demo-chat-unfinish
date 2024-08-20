package com.example.demo_chat_room.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Table("CHAT_ROOM")
@Data
public class ChatRoom {
    @Id
    private Long roomId;
    private String roomName;
    private String accessKey;
    private LocalDate created;
    private LocalDate updated;
}
