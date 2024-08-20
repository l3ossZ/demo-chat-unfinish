package com.example.demo_chat_room.Models.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long userId;
    private String userName;
    private String userRole;
    private String userEmail;
    private String accessKey;
}
