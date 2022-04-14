package petcarehotel.webapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petcarehotel.webapplication.models.Pet;

/**
 * JpaRepository for the Pet entity.
 */
public interface PetRepository extends JpaRepository<Pet, Long> {
}
