package com.example.demo.service;

import com.example.demo.entity.SanPham;

import java.util.List;

public interface ISanPhamService {
    List<SanPham> findAll();
    void addSanPham(SanPham sanPham);
    void delete(int id);
    void update (SanPham sanPham);
    SanPham findById(int id);
    List<SanPham> searchByName(String name);
}
