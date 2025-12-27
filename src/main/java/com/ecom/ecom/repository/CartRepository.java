package com.ecom.ecom.repository;

import com.ecom.ecom.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("""
        SELECT c FROM Cart c
        LEFT JOIN FETCH c.items i
        LEFT JOIN FETCH i.product
        WHERE c.id = :cartId
    """)
    Cart findCartWithItems(@Param("cartId") Long cartId);
}
