package com.example.gio_hang.Service;

import com.example.gio_hang.entity.CartItem;
import jakarta.servlet.http.HttpSession;

import java.util.Map;

public interface ICartService {
    void add(Integer id, HttpSession session);
    void update(Integer id, int quantity, HttpSession session);
    void remove(Integer id, HttpSession session);
    Map<Integer, CartItem> getCart(HttpSession session);
    double getTotal(HttpSession session);
}
