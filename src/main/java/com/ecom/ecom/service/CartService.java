package com.ecom.ecom.service;

import com.ecom.ecom.model.*;

import com.ecom.ecom.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    /**
     * Get cart if exists, otherwise create a new one.
     * This FIXES the first-time add-to-cart issue.
     */
    @Transactional
    public Cart getOrCreateCart(Long cartId) {
        if (cartId == null) {
            return cartRepository.save(new Cart());
        }

        return cartRepository.findById(cartId)
                .orElseGet(() -> cartRepository.save(new Cart()));
    }

    @Transactional
    public void addProductToCart(Long cartId, Long productId, int quantity) {
        Cart cart = getOrCreateCart(cartId);

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        cart.addItem(product, quantity);
    }

    @Transactional(readOnly = true)
    public Cart getCart(Long cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    @Transactional
    public void removeProductFromCart(Long cartId, Long productId) {
        Cart cart = getCart(cartId);

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        cart.removeItem(product);
    }

    @Transactional(readOnly = true)
    public List<CartItem> getCartItems(Long cartId) {
        Cart cart = getCart(cartId);
        cart.getItems().forEach(item -> item.getProduct().getName());
        return cart.getItems();
    }

    @Transactional(readOnly = true)
    public BigDecimal getCartTotal(Long cartId) {
        Cart cart = getCart(cartId);
        return cart.getTotal();
    }
}
