package petcarehotel.webapplication.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petcarehotel.webapplication.models.Review;

/**
 * JpaRepository for the Review entity.
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
  Review findReviewById(Long id);

  List<Review> findAll();

}
