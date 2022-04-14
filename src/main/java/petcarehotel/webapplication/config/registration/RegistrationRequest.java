package petcarehotel.webapplication.config.registration;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import petcarehotel.webapplication.models.enumerations.Role;

/**
 * Class for the RegistrationRequest.
 */
@RequiredArgsConstructor
@Getter
@Setter
public class RegistrationRequest {
  private final String username;
  private final String firstName;
  private final String lastName;
  private final String email;
  private final String password;
  private final String repeatPassword;
  private final Role role;

}