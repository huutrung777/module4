package com.example.gio_hang.Service;

import com.example.gio_hang.Repository.IProductRepository;
import com.example.gio_hang.entity.CartItem;
import com.example.gio_hang.entity.Product;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class CartService implements ICartService{
    @Autowired
    IProductRepository productRepository;
    private Map<Integer, CartItem> initCart(HttpSession session) {
        Map<Integer, CartItem> cart =
                (Map<Integer, CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    @Override
    public void add(Integer id, HttpSession session) {
        Map<Integer, CartItem> cart = initCart(session);

        Product p = productRepository.findById(id).orElse(null);
        if (p == null) return;

        if (cart.containsKey(id)) {
            cart.get(id).setQuantity(cart.get(id).getQuantity() + 1);
        } else {
            cart.put(id, new CartItem(
                    p.getId(),
                    p.getName(),
                    p.getPrice(),
                    1,
                    p.getImage()
            ));
        }
    }

    @Override
    public void update(Integer id, int quantity, HttpSession session) {
        Map<Integer, CartItem> cart = initCart(session);
        if (cart.containsKey(id)) {
            cart.get(id).setQuantity(quantity);
        }
    }

    @Override
    public void remove(Integer id, HttpSession session) {
        initCart(session).remove(id);
    }

    @Override
    public Map<Integer, CartItem> getCart(HttpSession session) {
        return initCart(session);
    }

    @Override
    public double getTotal(HttpSession session) {
        return initCart(session).values().stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
    }
}
