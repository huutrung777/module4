package com.example.gio_hang.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartItem {
    private Integer id;
    private String name;
    private double price;
    private int quantity;
    private String image;

    public CartItem(Integer id, String name, double price, int quantity, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }
}
