package com.ecom.ecom.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

import com.ecom.ecom.model.*;
import com.ecom.ecom.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class ProductServiceTest {

    @Mock private ProductRepository productRepository;
    @InjectMocks private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = Arrays.asList(new Product(), new Product());
        when(productRepository.findAll()).thenReturn(products);
        List<Product> result = productService.getAllProducts();
        assertEquals(2, result.size());
    }
}
