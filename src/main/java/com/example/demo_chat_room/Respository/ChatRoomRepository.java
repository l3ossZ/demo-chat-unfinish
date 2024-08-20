package com.example.demo_chat_room.Respository;

import com.example.demo_chat_room.Models.ChatRoom;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ChatRoomRepository extends ReactiveCrudRepository<ChatRoom,Long> {

}
