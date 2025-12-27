package com.ecom.ecom.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.ecom.ecom.model.*;
import com.ecom.ecom.repository.*;
import com.ecom.ecom.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class CustomerOrderServiceTest {

    @Mock private CustomerOrderRepository customerOrderRepository;
    @InjectMocks private CustomerOrderService customerOrderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveOrder() {
        CustomerOrder order = new CustomerOrder();
        when(customerOrderRepository.save(order)).thenReturn(order);
        CustomerOrder saved = customerOrderService.saveOrder(order);
        assertEquals(order, saved);
    }

    @Test
    void testFindOrderById() {
        CustomerOrder order = new CustomerOrder();
        when(customerOrderRepository.findById(1L)).thenReturn(java.util.Optional.of(order));
        CustomerOrder found = customerOrderService.findOrderById(1L);
        assertNotNull(found);
    }
}
