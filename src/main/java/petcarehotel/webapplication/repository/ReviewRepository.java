package petcarehotel.webapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petcarehotel.webapplication.models.Review;
import petcarehotel.webapplication.models.User;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
  Review findReviewById(Long id);

  List<Review> findAll();
}
