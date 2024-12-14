package com.artipo.artipo.controller;

import com.artipo.artipo.dto.UserDto;
import com.artipo.artipo.entity.User;
import com.artipo.artipo.mapper.UserMapper;
import com.artipo.artipo.service.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String submit(@ModelAttribute UserDto userDto, HttpSession session) {

        String email = (String) session.getAttribute("email");
        userDto.setEmail(email);
        
        //2024.12.15 role default값 넣어주고, nickname 값 따로 넣어주기

        System.out.println("User Data Submitted:");
        System.out.println("Name: " + userDto.getName());
        System.out.println("Nickname: " + userDto.getNickname());
        System.out.println("Email: " + userDto.getEmail());
        System.out.println("Password: " + userDto.getPassword());
        System.out.println("Birth: " + userDto.getBirth());
        System.out.println("Gender: " + userDto.getGender());
        System.out.println("Mobile Number: " + userDto.getMobile_number());

        User user = UserMapper.toEntity(userDto);

        userServiceImpl.createUser(user);

        session.setAttribute("user",userDto);
        return "/register/success";
    }

}
