package com.example.blog.repository;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findByTieuDeContaining(String tieuDe, Pageable pageable);

    Page<Blog> findByCategory_Id(int categoryId, Pageable pageable);
}