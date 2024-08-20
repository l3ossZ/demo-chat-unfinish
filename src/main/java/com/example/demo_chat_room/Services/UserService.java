package com.example.demo_chat_room.Services;

import com.example.demo_chat_room.DAO.UserDAO;
import com.example.demo_chat_room.Models.DTO.UserDTO;
import com.example.demo_chat_room.Models.User;
import com.example.demo_chat_room.Respository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserDAO userDAO;
    private final Sinks.Many<User> userSink=Sinks.many().multicast().onBackpressureBuffer();
    private final Sinks.Many<UserDTO> userDTOSink=Sinks.many().multicast().onBackpressureBuffer();


    public Flux<UserDTO> getAllUsersDTO(){
        userDAO.getAllUsers().subscribe(userDTOSink::tryEmitNext);
        return userDTOSink.asFlux();
    }

    public Mono<User> addUser(User user){
        user.setCreated(LocalDate.from(LocalDateTime.now()));
        user.setUpdated(LocalDate.from(LocalDateTime.now()));
        return userRepository.save(user)
                .doOnNext(addNewUser->
                        userSink.tryEmitNext(addNewUser).orThrow());
    }

    public Mono<User> getUserById(Long userId){
        return userRepository.findById(userId);
    }


}
