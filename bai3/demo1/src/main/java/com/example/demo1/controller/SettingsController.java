package com.example.demo1.controller;

import com.example.demo1.entity.Settings;
import com.example.demo1.service.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/settings")
public class SettingsController {

    @Autowired
    private ISettingsService settingsService;

    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("settings", settingsService.getSettings());
        return "settings";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("settings") Settings settings){
        settingsService.update(settings);
        return "redirect:/settings";
    }
}
