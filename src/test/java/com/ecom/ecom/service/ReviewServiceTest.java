package com.ecom.ecom.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

import com.ecom.ecom.model.*;
import com.ecom.ecom.repository.*;
import com.ecom.ecom.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class ReviewServiceTest {

    @Mock private ReviewRepository reviewRepository;
    @InjectMocks private ReviewService reviewService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllReviews() {
        List<Review> reviews = Arrays.asList(new Review(), new Review());
        when(reviewRepository.findAll()).thenReturn(reviews);
        List result = reviewService.getAllReviews();
        assertEquals(2, result.size());
    }

    @Test
    void testSaveReview() {
        Review review = new Review();
        when(reviewRepository.save(review)).thenReturn(review);
        Review saved = reviewService.saveReview(review);
        assertEquals(review, saved);
    }

    @Test
    void testDeleteReview() {
        doNothing().when(reviewRepository).deleteById(1L);
        reviewService.deleteReview(1L);
        verify(reviewRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetReviewById() {
        Review review = new Review();
        when(reviewRepository.findById(1L)).thenReturn(java.util.Optional.of(review));
        Review found = reviewService.getReviewById(1L);
        assertNotNull(found);
    }
}
