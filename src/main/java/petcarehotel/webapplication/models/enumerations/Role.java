package petcarehotel.webapplication.models.enumerations;

import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Enumeration for the User role.
 */
public enum Role implements GrantedAuthority {
  ROLE_USER, ROLE_ADMIN;


  @Override
  public String getAuthority() {
    return name();
  }

  private static final List<Role> VALUES =
          Collections.unmodifiableList(Arrays.asList(values()));
  private static final int SIZE = VALUES.size();
  private static final Random RANDOM = new Random();

  public static Role getRandomRole()  {
    return VALUES.get(RANDOM.nextInt(SIZE));
  }
}
