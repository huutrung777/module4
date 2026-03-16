package com.example.demo.rebository;

import com.example.demo.entity.SanPham;

import java.util.List;

public interface ISanPhamRepository {
    List<SanPham> findAll();
    boolean addSanPham(SanPham sanPham);
    boolean delete(String name);
    boolean update (SanPham sanPham);
    SanPham findById(int id);

}
