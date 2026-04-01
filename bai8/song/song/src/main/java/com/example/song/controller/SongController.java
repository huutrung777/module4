package com.example.song.controller;

import com.example.song.dto.SongDto;
import com.example.song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }
    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "list";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("songDto") SongDto songDto,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        songService.save(songDto);
        return "redirect:/songs";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        SongDto songDto = songService.findById(id);
        model.addAttribute("songDto", songDto);
        return "edit";
    }
}
