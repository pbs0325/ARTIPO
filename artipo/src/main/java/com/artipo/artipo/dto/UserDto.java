package com.artipo.artipo.dto;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserDto {

    private long user_id;

    private String name;
    private String nickname;
    private String password;
    private String email;
    private String mobile_number;
    private String role;
    private String gender;
    private LocalDate birth;

    private LocalDateTime created_at;
}
