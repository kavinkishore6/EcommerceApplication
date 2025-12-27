package com.ecom.ecom.service;

import static org.mockito.Mockito.*;
import com.ecom.ecom.model.*;

import com.ecom.ecom.service.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class CheckoutServiceTest {

    @Mock private CartService cartService;
    @InjectMocks private CheckoutService checkoutService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessCheckout() {
        Checkout checkout = new Checkout();
        Cart cart = new Cart();
        when(cartService.getCart(1L)).thenReturn(cart);
        // No assert as processCheckout is void, but verify interaction
        checkoutService.processCheckout(checkout, 1L);
        verify(cartService, times(1)).getCart(1L);
    }
}
