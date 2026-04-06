package com.example.gio_hang.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    private Integer id;
    private String name;
    private double price;
    private String image;

    public ProductDTO(Integer id, String name, double price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }
}
