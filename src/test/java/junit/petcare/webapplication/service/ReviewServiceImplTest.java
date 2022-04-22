package junit.petcare.webapplication.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import petcarehotel.webapplication.models.Review;
import petcarehotel.webapplication.repository.ReviewRepository;
import petcarehotel.webapplication.service.impl.ReviewServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static support.TestObjectGenerator.generateReview;

public class ReviewServiceImplTest {
  private ReviewServiceImpl instanceUnderTest;
  private ReviewRepository reviewRepository;

  @BeforeEach
  void init() {
    reviewRepository = mock(ReviewRepository.class);
    instanceUnderTest = new ReviewServiceImpl(reviewRepository);
  }

  @Test
  void testSaveReview() {
    final var review = generateReview();

    when(reviewRepository.save(any(Review.class))).thenReturn(review);

    final var result = this.instanceUnderTest.create(review.getText(), review.getUser(), review.getRatingDouble());

    assertNotNull(result);
    assertEquals(review.getId(), result.getId());
    verify(reviewRepository).save(any(Review.class));
  }

  @Test
  void testFindReviewById() {
    final var review = mock(Review.class);

    when(reviewRepository.findReviewById(review.getId())).thenReturn(review);

    final var result = this.instanceUnderTest.findById(review.getId());

    assertEquals(review, result);
    verify(reviewRepository).findReviewById(review.getId());
  }

  @Test
  void testFindAllReviews() {
    final var reviews = List.of(mock(Review.class));

    when(reviewRepository.findAll()).thenReturn(reviews);

    final var result = this.instanceUnderTest.findAll();

    assertEquals(reviews, result);
    verify(reviewRepository).findAll();
  }

  @Test
  void testUpdateReview() {
    final var review = mock(Review.class);

    when(reviewRepository.findReviewById(review.getId())).thenReturn(review);

    final var result = this.instanceUnderTest.update(review.getId(), review.getText(), review.getUser());

    assertNotNull(result);
    assertEquals(review.getId(), result.getId());
    verify(reviewRepository).findReviewById(review.getId());
  }

  @Test
  void testDeleteReview() {
    final var review = mock(Review.class);

    final var result = instanceUnderTest.delete(review.getId());

    assertNull(result);
  }
}
