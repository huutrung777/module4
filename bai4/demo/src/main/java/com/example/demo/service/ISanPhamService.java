package com.example.demo.service;

import com.example.demo.entity.SanPham;

import java.util.List;

public interface ISanPhamService {
    List<SanPham> findAll();
    boolean addSanPham(SanPham sanPham);
    boolean delete(int id);
    boolean update (SanPham sanPham);
    SanPham findById(int id);
    List<SanPham> searchByName(String name);
}
