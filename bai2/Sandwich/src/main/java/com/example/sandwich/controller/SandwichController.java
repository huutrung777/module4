package com.example.sandwich.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment, Model model) {

        model.addAttribute("list", condiment);

        return "result";
    }
}
