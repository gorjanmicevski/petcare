package petcarehotel.webapplication.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import petcarehotel.webapplication.models.Review;
import petcarehotel.webapplication.models.User;
import petcarehotel.webapplication.repository.ReviewRepository;
import petcarehotel.webapplication.service.ReviewService;

/**
 * Service implementation for the Review entity.
 */
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

  private final ReviewRepository reviewRepository;

  @Override
  public Review findById(Long id) {
    return reviewRepository.findReviewById(id);
  }

  @Override
  public List<Review> findAll() {
    return reviewRepository.findAll();
  }

  @Override
  public Review create(String text, User user, Double rating) {
    Review review = new Review(text, user, rating);
    reviewRepository.save(review);
    return review;
  }

  @Override
  public Review update(Long id, String text, User user) {
    Review r = reviewRepository.findReviewById(id);
    r.setText(text);
    r.setUser(user);
    return r;
  }

  @Override
  public Review delete(Long id) {
    Review r = reviewRepository.findReviewById(id);
    reviewRepository.delete(r);
    return r;
  }
}
