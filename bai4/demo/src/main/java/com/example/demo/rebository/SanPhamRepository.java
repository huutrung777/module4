package com.example.demo.rebository;

import com.example.demo.entity.SanPham;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SanPhamRepository implements ISanPhamRepository {
private static List<SanPham> sanPhamList = new ArrayList<>();
static {
    sanPhamList.add(new SanPham(1,"Iphone",1000));
    sanPhamList.add(new SanPham(2,"Galaxy",900));
    sanPhamList.add(new SanPham(3,"Macbook",2000));

}
    @Override
    public List<SanPham> findAll() {
        return sanPhamList;
    }

    @Override
    public boolean addSanPham(SanPham sanPham) {
    sanPhamList.add(sanPham);
        return true;
    }

    @Override
    public boolean delete(String name) {
        for (SanPham sp : sanPhamList) {
            if (sp.getName().equals(name)) {
                sanPhamList.remove(sp);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(SanPham sanPham) {
        for (SanPham sp : sanPhamList) {
            if (sp.getId() == sanPham.getId()) {
                sp.setName(sanPham.getName());
                sp.setPrice(sanPham.getPrice());
                return true;
            }
        }
        return false;
    }

    @Override
    public SanPham findById(int id) {
        for (SanPham sp : sanPhamList) {
            if (sp.getId() == id) {
                return sp;
            }
        }
        return null;
    }
}
