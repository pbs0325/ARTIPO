package com.artipo.artipo.mapper;

import com.artipo.artipo.dto.ProfileDto;
import com.artipo.artipo.entity.Profile;

public class ProfileMapper {

    public static Profile toEntity(ProfileDto profileDto) {
        Profile profile = new Profile();
        profile.setNickName(profileDto.getNickname());
        profile.setUserPicture(profileDto.getUserPicture());

        return profile;
    }
}
