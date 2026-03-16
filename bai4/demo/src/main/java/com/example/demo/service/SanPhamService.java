package com.example.demo.service;

import com.example.demo.entity.SanPham;
import com.example.demo.rebository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SanPhamService implements ISanPhamService {
@Autowired
private SanPhamRepository sanPhamRepository;
    @Override
    public List<SanPham> findAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public boolean addSanPham(SanPham sanPham) {
        return sanPhamRepository.addSanPham(sanPham);
    }

    @Override
    public boolean delete(String name) {
        return sanPhamRepository.delete(name);
    }

    @Override
    public boolean update(SanPham sanPham) {
        return sanPhamRepository.update(sanPham);
    }

    @Override
    public SanPham findById(int id) {
        return sanPhamRepository.findById(id);
    }
}
