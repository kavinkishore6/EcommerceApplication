package com.ecom.ecom.controller;

import com.ecom.ecom.model.*;
import com.ecom.ecom.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String showProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products found");
        } else {
            System.out.println("Products found: " + products.size());
        }
        model.addAttribute("products", products);
        return "products";
    }
}
