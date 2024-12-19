package com.artipo.artipo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="profile")
@Data
public class Profile {

    @Id
    @Column(name="user_id")
    private long userId;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name="user_picture")
    private String userPicture;
    @Column(name="nickname")
    private String nickName;
}
