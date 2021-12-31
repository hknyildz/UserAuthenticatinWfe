package com.hknyildz.challange.controller;

import com.hknyildz.challange.dto.UserDto;
import com.hknyildz.challange.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/home")
    public String viewLoginPage() {
        return "home";
    }

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }


    @GetMapping("/register")
    public String viewSignUpForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "signup_form";
    }

    @PostMapping(value = "/process_register")
    public String processRegistration(UserDto user) throws Exception {
        userService.createUser(user);
        return "register_success";
    }


}