package com.example.blog.repository;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository  extends JpaRepository<Blog, Integer> {
    @Query("SELECT b FROM Blog b WHERE b.tieuDe LIKE %:tieuDe%")
    Page<Blog> search(@Param("tieuDe") String tieuDe, Pageable pageable);
}
