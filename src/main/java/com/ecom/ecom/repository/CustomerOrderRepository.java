package com.ecom.ecom.repository;

import com.ecom.ecom.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
