package com.example.gio_hang.controller;

import com.example.gio_hang.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("list", productService.findAll());
        return "list";
    }

    @GetMapping("/product/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        model.addAttribute("p", productService.findById(id));
        return "detail";
    }
}
