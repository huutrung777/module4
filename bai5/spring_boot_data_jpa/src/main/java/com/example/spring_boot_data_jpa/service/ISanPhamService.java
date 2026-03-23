package com.example.spring_boot_data_jpa.service;

import com.example.spring_boot_data_jpa.entity.SanPham;

import java.util.List;

public interface ISanPhamService {
    List<SanPham> findAll();
    void addSanPham(SanPham sanPham);
    void delete(int id);
    void update (SanPham sanPham);
    SanPham findById(int id);
    List<SanPham> searchByName(String name);
}
