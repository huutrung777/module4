package com.example.login1.controller;

import com.example.login1.dto.UserDto;
import com.example.login1.entity.User;
import com.example.login1.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("userDto", new UserDto());
        return "index";
    }

    @PostMapping("/submit")
    public String submitForm(@Valid @ModelAttribute("userDto") UserDto userDto,
                             BindingResult bindingResult,
                             Model model){
        if(bindingResult.hasErrors()){
            return "index";
        }
        User user = new User();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        userService.save(user);

        model.addAttribute("user", user);
        return "result";
    }
}