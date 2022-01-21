package petcarehotel.webapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import petcarehotel.webapplication.models.User;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {
    User findByUsernameEqualsOrEmailEquals(String username,String email);
    Optional<User> findByUsername(String usename);
    Optional<User> findByEmail(String email);
    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.isEnabled = TRUE WHERE a.email = ?1")
    int enableUser(String email);
    User findUserById(Long id);
    User findUserByUsername(String username);
}
