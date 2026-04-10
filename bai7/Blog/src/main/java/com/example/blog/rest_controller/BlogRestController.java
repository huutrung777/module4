package com.example.blog.rest_controller;

import com.example.blog.entity.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogRestController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public Page<Blog> getAll(@RequestParam(defaultValue = "0") int page) {

        Pageable pageable = PageRequest.of(page, 5,
                Sort.by("createDate").descending());

        return blogService.findAll(pageable);
    }

    @GetMapping("/ajax/search")
    public List<Blog> ajaxSearch(@RequestParam String keyword,
                                 @RequestParam(defaultValue = "0") int page) {

        Pageable pageable = PageRequest.of(page, 5,
                Sort.by("createDate").descending());

        return blogService.search(keyword, pageable).getContent();
    }
    @GetMapping("/ajax/load-more")
    public List<Blog> loadMore(@RequestParam int page) {

        Pageable pageable = PageRequest.of(page, 5,
                Sort.by("createDate").descending());

        return blogService.findAll(pageable).getContent();
    }

    @PostMapping("")
    public Blog create(@RequestBody Blog blog) {
        blog.setCreateDate(LocalDateTime.now());
        blogService.addBlog(blog);
        return blog;
    }

    @PutMapping("/{id}")
    public Blog update(@PathVariable int id, @RequestBody Blog blog) {

        Blog old = blogService.findById(id);
        blog.setId(id);
        blog.setCreateDate(old.getCreateDate());

        blogService.update(blog);
        return blog;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        blogService.delete(id);
    }
}