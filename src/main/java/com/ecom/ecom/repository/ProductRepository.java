package com.ecom.ecom.repository;

import com.ecom.ecom.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
