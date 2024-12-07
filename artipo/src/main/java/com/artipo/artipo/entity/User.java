package com.artipo.artipo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    private String user_name;
    private String password;
    private String email;
    private String mobile_number;
    private String role;

    @CreationTimestamp
    private LocalDateTime created_at;


}
