package com.artipo.artipo.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ProfileDto {

    @Column(name="user_id")
    private long userId;
    @Column(name="user_picture")
    private String userPicture;
    private String nickname;
}
