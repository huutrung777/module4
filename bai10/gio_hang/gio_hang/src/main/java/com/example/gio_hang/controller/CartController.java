package com.example.gio_hang.controller;

import com.example.gio_hang.Service.ICartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @Autowired
    private ICartService cartService;

    @GetMapping("/cart")
    public String cart(HttpSession session, Model model) {
        model.addAttribute("cart", cartService.getCart(session));
        model.addAttribute("total", cartService.getTotal(session));
        return "cart";
    }

    @GetMapping("/cart/add")
    public String add(@RequestParam Integer id, HttpSession session) {
        cartService.add(id, session);
        return "redirect:/cart";
    }

    @GetMapping("/cart/update")
    public String update(@RequestParam Integer id,
                         @RequestParam int quantity,
                         HttpSession session) {
        cartService.update(id, quantity, session);
        return "redirect:/cart";
    }

    @GetMapping("/cart/remove")
    public String remove(@RequestParam Integer id, HttpSession session) {
        cartService.remove(id, session);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(HttpSession session) {
        session.removeAttribute("cart");
        return "success";
    }
}
