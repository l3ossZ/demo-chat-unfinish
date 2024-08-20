package com.example.demo_chat_room.DAO;

import com.example.demo_chat_room.Models.DTO.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final DatabaseClient databaseClient;

    public Flux<UserDTO> getAllUsers(){
        String queryString=" SELECT * FROM USER ";
        //databaseClient .sql(queryString)
        Flux<UserDTO> result=databaseClient.sql(queryString).mapProperties(UserDTO.class).all();
        return result;
    }
}
