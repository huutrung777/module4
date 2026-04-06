package com.example.blog.rest_controller;

import com.example.blog.entity.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ResponseEntity<List<Blog>> getAll(){
        List<Blog> students = blogService.findAll();
        if (students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable int id) {
        return blogService.findById(id);
    }

    @PostMapping("")
    public Blog createBlog(@RequestBody Blog blog) {
        blogService.addBlog(blog);
        return blog;
    }
    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable int id,
                           @RequestBody Blog blog) {
        blog.setId(id);
        blogService.update(blog);
        return blog;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog not found");
        }
        blogService.delete(id);
        return ResponseEntity.ok(blog);
    }


}
