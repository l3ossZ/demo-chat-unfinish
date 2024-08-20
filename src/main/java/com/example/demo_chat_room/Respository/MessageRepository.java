package com.example.demo_chat_room.Respository;

import com.example.demo_chat_room.Models.Message;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MessageRepository extends ReactiveCrudRepository<Message,Long> {

}
