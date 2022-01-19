package petcarehotel.webapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petcarehotel.webapplication.models.Pet;

public interface PetRepository extends JpaRepository<Pet,Long> {
}
