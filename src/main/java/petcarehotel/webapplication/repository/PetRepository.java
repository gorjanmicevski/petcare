package petcarehotel.webapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petcarehotel.webapplication.models.Pet;

/**
 * JpaRepository for the Pet entity.
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
