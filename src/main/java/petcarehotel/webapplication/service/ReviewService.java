package petcarehotel.webapplication.service;

import petcarehotel.webapplication.models.Review;
import petcarehotel.webapplication.models.User;

import java.util.List;

public interface ReviewService {
  Review findById(Long id);

  List<Review> findAll();

  Review create(String text, User user, Double rating);

  Review update(Long id, String text, User user);

  Review delete(Long id);

}
