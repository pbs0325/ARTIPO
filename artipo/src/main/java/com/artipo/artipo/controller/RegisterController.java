package com.artipo.artipo.controller;

import com.artipo.artipo.dto.UserDto;
import com.artipo.artipo.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @GetMapping("/resister")
    public String resister() {
        return "resister/resister";
    }

    @GetMapping("/resister/onboarding")
    public String onboarding(@RequestParam() String email, HttpSession session) {
        session.setAttribute("email", email);
        return "resister/onboarding";
    }

    @PostMapping ("/resister/submit")
    public String submit(@ModelAttribute UserDto userDto, HttpSession session) {

        String email = (String) session.getAttribute("email");

        User user = new User();


        session.setAttribute("user",userDto);

        return "resister/onboarding";
    }

}
