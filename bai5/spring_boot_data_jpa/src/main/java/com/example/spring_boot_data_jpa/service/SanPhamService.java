package com.example.spring_boot_data_jpa.service;

import com.example.spring_boot_data_jpa.entity.SanPham;
import com.example.spring_boot_data_jpa.repository.ISanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SanPhamService implements ISanPhamService {

    @Autowired
    private ISanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> findAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public void addSanPham(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void delete(int id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public void update(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public SanPham findById(int id) {
        return sanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public List<SanPham> searchByName(String name) {
        return sanPhamRepository.findByNameContaining(name);
    }
}
