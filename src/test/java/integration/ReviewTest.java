package integration;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import petcarehotel.webapplication.service.ReviewService;
import petcarehotel.webapplication.service.UserService;
import support.ModuleTest;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.*;
import static support.TestObjectGenerator.generateIntegrationReview;
import static support.TestObjectGenerator.generateUser;

@ModuleTest
@RequiredArgsConstructor
public class ReviewTest {
  private final ReviewService reviewService;
  private final UserService userService;

  @Test
  void testCreateReview() {
    final var review = generateIntegrationReview();

    final var user = generateUser();
    userService.addUser(user);

    final var result = reviewService.create(review.getText(), user, review.getRatingDouble());

    assertNotNull(result.getId());
  }

  @Test
  void testGetAllReviews() {
    final var reviews = reviewService.findAll();

    assertNotNull(reviews);
    assertTrue(reviews.size() > 0);
  }

  @Test
  void testGetReviewById() {
    var review = generateIntegrationReview();

    final var user = generateUser();
    userService.addUser(user);

    review = reviewService.create(review.getText(), user, review.getRatingDouble());

    final var result = reviewService.findById(review.getId());

    assertNotNull(result);
    assertEquals(result.getId(), review.getId());
  }

  @Test
  void testUpdateReview() {
    var review = generateIntegrationReview();

    final var user = generateUser();
    userService.addUser(user);

    review = reviewService.create(review.getText(), user, review.getRatingDouble());

    var updatedResult = review;
    updatedResult.setText(randomUUID().toString());

    updatedResult = reviewService.update(review.getId(), updatedResult.getText(), user);

    assertEquals(updatedResult.getId(), review.getId());
  }

  @Test
  void testRemoveReview() {
    var review = generateIntegrationReview();

    final var user = generateUser();
    userService.addUser(user);

    review = reviewService.create(review.getText(), user, review.getRatingDouble());

    review = reviewService.delete(review.getId());

    final var result = reviewService.findById(review.getId());

    assertNull(result);
  }
}
