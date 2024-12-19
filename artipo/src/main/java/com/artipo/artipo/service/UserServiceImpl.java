package com.artipo.artipo.service;

import com.artipo.artipo.entity.Profile;
import com.artipo.artipo.entity.User;
import com.artipo.artipo.repository.ProfileRepository;
import com.artipo.artipo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository , ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public User createUserWithProfile(User user, Profile profile) {

        User savedUser = userRepository.save(user);

        // Profile에 User 설정
        profile.setUser(savedUser);

        Profile savedProfile = profileRepository.save(profile);

        return savedUser;
    }

}
