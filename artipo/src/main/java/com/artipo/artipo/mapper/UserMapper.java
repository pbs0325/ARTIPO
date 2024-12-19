package com.artipo.artipo.mapper;

import com.artipo.artipo.dto.UserDto;
import com.artipo.artipo.entity.User;

public class UserMapper {

    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setGender(userDto.getGender());
        user.setBirth(userDto.getBirth());
        user.setMobileNumber(userDto.getMobileNumber());
        user.setCreatedAt(userDto.getCreatedAt());
        user.setRole(userDto.getRole());
        return user;
    }
}
