package com.artipo.artipo.controller;

import com.artipo.artipo.dto.ProfileDto;
import com.artipo.artipo.dto.UserDto;
import com.artipo.artipo.entity.Profile;
import com.artipo.artipo.entity.User;
import com.artipo.artipo.mapper.ProfileMapper;
import com.artipo.artipo.mapper.UserMapper;
import com.artipo.artipo.service.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class RegisterController {

    private final UserServiceImpl userServiceImpl;

    public RegisterController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/register")
    public String resister() {
        return "/register/register";
    }

    @PostMapping("/register/onboarding")
    public String onboarding(@RequestParam() String email, HttpSession session) {
        session.setAttribute("email", email);
        return "/register/onboarding";
    }

    @PostMapping ("/register/submit")
    public String submit(
            UserDto userDto, @ModelAttribute ProfileDto profileDto, HttpSession session) {

        //Session에서 미리 저장해 놓은 email값 불러오기
        String email = (String) session.getAttribute("email");
        userDto.setEmail(email);

        //role 기본값으로 "User" 넣어주기
        String role = "User";
        userDto.setRole(role);

        // create_at 현재 시간으로 설정
        userDto.setCreatedAt(LocalDateTime.now());

        //nickname과 user_picture 주소 profileDto로 넣어주기
        String nickname = profileDto.getNickname();
        String userPicture = profileDto.getUserPicture();

        System.out.println("User Data Submitted:");
        System.out.println("Name: " + userDto.getName());
        System.out.println("Role:" + userDto.getRole());
        System.out.println("Nickname: " + profileDto.getNickname());
        System.out.println("Email: " + userDto.getEmail());
        System.out.println("Password: " + userDto.getPassword());
        System.out.println("Birth: " + userDto.getBirth());
        System.out.println("Gender: " + userDto.getGender());
        System.out.println("Mobile Number: " + userDto.getMobileNumber());

        User user = UserMapper.toEntity(userDto);
        Profile profile = ProfileMapper.toEntity(profileDto);

        userServiceImpl.createUserWithProfile(user, profile);

        return "/register/success";
    }

}
