package com.ecom.ecom.controller;
import com.ecom.ecom.model.*;
import com.ecom.ecom.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam("productId") Long productId,
                            @RequestParam(value = "quantity", defaultValue = "1") int quantity,
                            HttpSession session) {

        Long cartId = (Long) session.getAttribute("cartId");

        // 🔥 FIX: Create cart if not exists
        Cart cart = cartService.getOrCreateCart(cartId);

        session.setAttribute("cartId", cart.getId());

        cartService.addProductToCart(cart.getId(), productId, quantity);

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {

        Long cartId = (Long) session.getAttribute("cartId");

        if (cartId == null) {
            Cart cart = cartService.getOrCreateCart(null);
            cartId = cart.getId();
            session.setAttribute("cartId", cartId);
        }

        Cart cart = cartService.getCart(cartId);
        model.addAttribute("cart", cart);

        BigDecimal total = cart.getTotal();
        DecimalFormat df = new DecimalFormat("Rs 0.00");
        model.addAttribute("total", df.format(total));

        return "cart";
    }

    @PostMapping("/cart/remove")
    public String removeFromCart(@RequestParam("productId") Long productId,
                                 HttpSession session) {

        Long cartId = (Long) session.getAttribute("cartId");

        if (cartId != null) {
            cartService.removeProductFromCart(cartId, productId);
        }

        return "redirect:/cart";
    }

    @PostMapping("/cart/checkout")
    public String checkout(HttpSession session) {
        return "redirect:/checkout";
    }
}
