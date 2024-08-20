package com.example.demo_chat_room.Controller;

import com.example.demo_chat_room.DAO.UserDAO;
import com.example.demo_chat_room.Models.DTO.UserDTO;
import com.example.demo_chat_room.Models.User;
import com.example.demo_chat_room.Services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Log4j2
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/get-all-users", produces = MediaType.TEXT_EVENT_STREAM_VALUE )
    public Flux<?> getAllUsers(){
        Flux<ServerSentEvent<UserDTO>> userFlux=userService.getAllUsersDTO()
                .doOnNext(user -> log.info("get user: "+user))
                .doOnError(error->log.error("Error: "+error))
                .map(user -> ServerSentEvent.builder(user)
                        .id(String.valueOf(user.getUserId()))
                        .event("user")
                        .build());
        return userFlux;
    }
    @PostMapping("/add-user")
    public Mono<ResponseEntity<?>> addUser(@RequestBody User user){
        return userService.addUser(user).map(ResponseEntity::ok);
    }


}
