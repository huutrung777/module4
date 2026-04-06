package com.example.gio_hang.Repository;

import com.example.gio_hang.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Integer> {
}
