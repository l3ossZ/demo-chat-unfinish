package com.example.demo_chat_room.Respository;

import com.example.demo_chat_room.Models.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User,Long> {

}
