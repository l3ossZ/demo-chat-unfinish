package com.example.demo_chat_room.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("MESSAGE")
@Data
public class Message {
    @Id
    private Long messageId;
    private Long roomId;
    private String messageText;
    private String userId;
    private LocalDate created;
    private LocalDate updated;
}
