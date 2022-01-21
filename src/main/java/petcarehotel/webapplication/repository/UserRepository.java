package petcarehotel.webapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petcarehotel.webapplication.models.User;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {
    User findByUsernameEqualsOrEmailEquals(String username,String email);
    Optional<User> findByUsername(String usename);
    Optional<User> findByEmail(String email);
}
