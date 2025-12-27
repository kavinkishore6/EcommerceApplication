// package com.sarankirthic.ecom.service;

// import static org.mockito.Mockito.*;
// import static org.junit.jupiter.api.Assertions.*;

// import com.sarankirthic.ecom.model.User;
// import com.sarankirthic.ecom.repository.UserRepository;
// import com.sarankirthic.ecom.service.UserService;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.*;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// public class UserServiceTest {

//     @Mock private UserRepository userRepository;
//     @Mock private BCryptPasswordEncoder bCryptPasswordEncoder;
//     @InjectMocks private UserService userService;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     void testSave() {
//         User user = new User();
//         user.setPassword("plain");
//         when(bCryptPasswordEncoder.encode("plain")).thenReturn("hashed");
//         when(userRepository.save(any(User.class))).thenReturn(user);
//         User saved = userService.save(user);
//         assertNotNull(saved);
//         verify(userRepository).save(user);
//         assertEquals("hashed", user.getPassword());
//     }

//     @Test
//     void testFindByUsername() {
//         User user = new User();
//         when(userRepository.findByUsername("jack")).thenReturn(user);
//         User found = userService.findByUsername("jack");
//         assertEquals(user, found);
//     }
// }
