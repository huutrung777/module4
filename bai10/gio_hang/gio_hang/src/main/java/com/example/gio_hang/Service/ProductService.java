package com.example.gio_hang.Service;

import com.example.gio_hang.Repository.IProductRepository;
import com.example.gio_hang.entity.Product;
import com.example.gio_hang.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository productRepository;
    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream()
                .map(p -> new ProductDTO(
                        p.getId(),
                        p.getName(),
                        p.getPrice(),
                        p.getImage()))
                .toList();
    }

    @Override
    public ProductDTO findById(Integer id) {
        Product p = productRepository.findById(id).orElse(null);
        if (p == null) return null;

        return new ProductDTO(
                p.getId(),
                p.getName(),
                p.getPrice(),
                p.getImage()
        );
    }
}
