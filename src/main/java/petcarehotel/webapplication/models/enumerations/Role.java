package petcarehotel.webapplication.models.enumerations;

import org.springframework.security.core.GrantedAuthority;

/**
 * Enumeration for the User role.
 */
public enum Role implements GrantedAuthority {
  ROLE_USER, ROLE_ADMIN;


  @Override
  public String getAuthority() {
    return name();
  }
}
