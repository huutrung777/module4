package com.example.spring_boot_data_jpa.repository;

import com.example.spring_boot_data_jpa.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISanPhamRepository extends JpaRepository<SanPham, Integer> {
    List<SanPham> findByNameContaining(String name);
}
