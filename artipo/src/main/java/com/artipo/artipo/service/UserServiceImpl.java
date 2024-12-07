package com.artipo.artipo.service;

import com.artipo.artipo.entity.User;

public class UserServiceImpl implements UserService {

    @Override
    public User createUser(User user) {
        user.setUser_id();
    }

}
