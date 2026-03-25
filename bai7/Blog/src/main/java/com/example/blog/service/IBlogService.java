package com.example.blog.service;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void addBlog(Blog blog);
    Blog findById(int id);
    void delete(int id);
    void update(Blog blog);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> search(String tieuDe, Pageable pageable);

}
