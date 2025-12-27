package com.ecom.ecom.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FORCE eager loading to avoid LazyInitializationException in Thymeleaf
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "cart_id")
    private List<CartItem> items = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(Product product, int quantity) {
        CartItem item = items.stream()
                .filter(i -> i.getProduct().getId().equals(product.getId()))
                .findFirst()
                .orElse(null);

        if (item != null) {
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            CartItem newItem = new CartItem(product, quantity);
            items.add(newItem);
        }
    }

    public void removeItem(Product product) {
        items.removeIf(item -> item.getProduct().getId().equals(product.getId()));
    }

    public BigDecimal getTotal() {
        return items.stream()
                .map(CartItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
