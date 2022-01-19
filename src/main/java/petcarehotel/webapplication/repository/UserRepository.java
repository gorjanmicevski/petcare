package petcarehotel.webapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petcarehotel.webapplication.models.User;

public interface UserRepository  extends JpaRepository<User,Long> {
}
