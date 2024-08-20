package com.example.demo_chat_room.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("USER")
@Getter
@Setter
public class User {
    @Id
    @Column("USER_ID")
    private Long userId;

    @Column("USER_NAME")
    private String userName;

    @Column("USER_PASSWORD")
    private String userPassword;

    @Column("USER_EMAIL")
    private String userEmail;

    @Column("USER_ROLE")
    private String userRole;

    @Column("ACCESS_KEY")
    private String accessKey;

    @Column("CREATED")
    private LocalDate created;

    @Column("UPDATED")
    private LocalDate updated;
}
