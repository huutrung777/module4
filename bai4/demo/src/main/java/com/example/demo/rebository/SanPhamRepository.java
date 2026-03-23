package com.example.demo.rebository;

import com.example.demo.entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
@Transactional
public class SanPhamRepository implements ISanPhamRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SanPham> findAll() {
        return entityManager.createQuery("FROM SanPham", SanPham.class)
                .getResultList();
    }

    @Override
    public void addSanPham(SanPham sanPham) {
        entityManager.persist(sanPham);
    }

    @Override
    public void delete(int id) {
        SanPham sp = entityManager.find(SanPham.class, id);
        if (sp != null) {
            entityManager.remove(sp);
        }
    }

    @Override
    public void update(SanPham sanPham) {
        SanPham sp = entityManager.find(SanPham.class, sanPham.getId());
        if (sp != null) {
            sp.setName(sanPham.getName());
            sp.setPrice(sanPham.getPrice());
        }
    }
    @Override
    public SanPham findById(int id) {
        return entityManager.find(SanPham.class, id);
    }

    @Override
    public List<SanPham> searchByName(String name) {
        return entityManager.createQuery(
                        "FROM SanPham WHERE name LIKE :name", SanPham.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }
}
