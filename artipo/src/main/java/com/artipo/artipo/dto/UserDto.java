package com.artipo.artipo.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserDto {

    @Column(name="user_id")
    private long userId;
    @Column(name="mobile_number")
    private String mobileNumber;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    private String name;
    private String password;
    private String email;
    private String role;
    private String gender;
    private LocalDate birth;

}
