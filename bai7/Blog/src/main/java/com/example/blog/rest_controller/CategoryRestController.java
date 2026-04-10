package com.example.blog.rest_controller;

import com.example.blog.entity.Category;
import com.example.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryRestController {

    @Autowired
    private ICategoryRepository categoryRepository;

    @GetMapping
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryRepository.deleteById(id);
    }
    @GetMapping("/{id}")
    public Category getOne(@PathVariable int id) {
        return categoryRepository.findById(id).orElse(null);
    }
}