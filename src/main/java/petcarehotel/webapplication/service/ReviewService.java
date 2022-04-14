package petcarehotel.webapplication.service;

import java.util.List;
import petcarehotel.webapplication.models.Review;
import petcarehotel.webapplication.models.User;

/**
 * Service for the Review entity.
 */
public interface ReviewService {
  Review findById(Long id);

  List<Review> findAll();

  Review create(String text, User user, Double rating);

  Review update(Long id, String text, User user);

  Review delete(Long id);

}
