package com.artipo.artipo.service;

import com.artipo.artipo.entity.Profile;
import com.artipo.artipo.entity.User;

public interface UserService {

    User createUserWithProfile(User user, Profile profile);
}
