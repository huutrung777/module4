package com.example.demo.rebository;

import com.example.demo.entity.SanPham;
import com.example.demo.util.ConnectionUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class SanPhamRepository implements ISanPhamRepository {
//private static List<SanPham> sanPhamList = new ArrayList<>();
//static {
//    sanPhamList.add(new SanPham(1,"Iphone",1000));
//    sanPhamList.add(new SanPham(2,"Galaxy",900));
//    sanPhamList.add(new SanPham(3,"Macbook",2000));
//
//}
    @Override
    public List<SanPham> findAll() {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<SanPham> query = session.createQuery("from SanPham", SanPham.class);
        List<SanPham> sanPhamList = query.getResultList();
        session.close();
        return sanPhamList;
    }

    @Override
    public boolean addSanPham(SanPham sanPham) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(sanPham);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        SanPham sp = session.find(SanPham.class, id);

        if (sp != null) {
            session.delete(sp);
            transaction.commit();
            session.close();
            return true;
        }

        session.close();
        return false;
    }

    @Override
    public boolean update(SanPham sanPham) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(sanPham);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public SanPham findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        SanPham sp = session.find(SanPham.class, id);
        session.close();
        return sp;
    }

    @Override
    public List<SanPham> searchByName(String name) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<SanPham> query = session.createQuery(
                "from SanPham where name like :name", SanPham.class
        );
        query.setParameter("name", "%" + name + "%");
        List<SanPham> list = query.getResultList();
        session.close();
        return list;
    }
}
