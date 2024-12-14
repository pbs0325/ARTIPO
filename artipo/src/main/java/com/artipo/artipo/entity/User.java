package com.artipo.artipo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String name;
    private String password;
    private String email;
    private String mobile_number;
    private String role;
    private String gender;
    private LocalDate birth;

    @CreationTimestamp
    private LocalDateTime created_at;


}
