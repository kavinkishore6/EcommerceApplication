// package com.sarankirthic.ecom.service;

// import static org.mockito.Mockito.*;
// import static org.junit.jupiter.api.Assertions.*;

// import com.sarankirthic.ecom.model.Cart;
// import com.sarankirthic.ecom.model.Product;
// import com.sarankirthic.ecom.repository.CartRepository;
// import com.sarankirthic.ecom.repository.ProductRepository;
// import com.sarankirthic.ecom.service.CartService;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.*;

// public class CartServiceTest {

//     @Mock private CartRepository cartRepository;
//     @Mock private ProductRepository productRepository;
//     @InjectMocks private CartService cartService;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     void testGetCart_New() {
//         when(cartRepository.findById(anyLong())).thenReturn(java.util.Optional.empty());
//         Cart cart = cartService.getCart(1L);
//         assertNotNull(cart);
//     }

//     @Test
//     void testCreateCart() {
//         Cart mockCart = new Cart();
//         when(cartRepository.save(any(Cart.class))).thenReturn(mockCart);
//         Cart cart = cartService.createCart();
//         assertNotNull(cart);
//         verify(cartRepository, times(1)).save(any(Cart.class));
//     }

//     @Test
//     void testAddProductToCart() {
//         Cart cart = mock(Cart.class);
//         Product product = new Product();
//         when(cartRepository.findById(anyLong())).thenReturn(java.util.Optional.of(cart));
//         when(productRepository.findById(anyLong())).thenReturn(java.util.Optional.of(product));
//         cartService.addProductToCart(1L, 1L, 2);
//         verify(cart, times(1)).addItem(product, 2);
//     }

//     @Test
//     void testRemoveProductFromCart() {
//         Cart cart = mock(Cart.class);
//         Product product = new Product();
//         when(cartRepository.findById(anyLong())).thenReturn(java.util.Optional.of(cart));
//         when(productRepository.findById(anyLong())).thenReturn(java.util.Optional.of(product));
//         cartService.removeProductFromCart(1L, 1L);
//         verify(cart, times(1)).removeItem(product);
//     }
// }
