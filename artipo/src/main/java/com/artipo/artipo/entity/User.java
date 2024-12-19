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
    @Column(name="user_id")
    private Long userId;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Profile profile;
    @Column(name="mobile_number")
    private String mobileNumber;
    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;
    private String name;
    private String password;
    private String email;
    private String role;
    private String gender;
    private LocalDate birth;


}
