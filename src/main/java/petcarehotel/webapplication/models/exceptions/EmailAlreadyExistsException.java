package petcarehotel.webapplication.models.exceptions;

/**
 * Custom exception for already existing email.
 */
public class EmailAlreadyExistsException extends RuntimeException {
  public EmailAlreadyExistsException(String email) {
    super(String.format("User with email: %s already exists", email));
  }
}
