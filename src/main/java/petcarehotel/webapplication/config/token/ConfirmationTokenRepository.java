package petcarehotel.webapplication.config.token;

import java.time.LocalDateTime;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Integer> {

  Optional<ConfirmationToken> findByToken(String token);

  void deleteByUser_Email(String email);

  @Transactional
  @Modifying
  @Query("UPDATE ConfirmationToken c " +
      "SET c.confirmedAt = ?2 " +
      "WHERE c.token = ?1")
  int updateConfirmedAt(String token, LocalDateTime confirmedAt);
}