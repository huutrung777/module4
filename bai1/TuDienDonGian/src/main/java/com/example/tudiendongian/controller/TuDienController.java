package com.example.tudiendongian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class TuDienController {

    private static Map<String, String> TuDien = new LinkedHashMap<>();

    static {
        TuDien.put("hello", "xin chào");
        TuDien.put("book", "quyển sách");
        TuDien.put("computer", "máy tính");
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam("word") String word, Model model) {

        String result = TuDien.get(word);

        if (result == null) {
            result = "Không tìm thấy";
        }

        model.addAttribute("word", word);
        model.addAttribute("result", result);

        return "result";
    }
}