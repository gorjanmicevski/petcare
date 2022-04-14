package petcarehotel.webapplication.models.exceptions;

/**
 * Custom exception for username already existing.
 */
public class UsernameAlreadyExistsException extends RuntimeException {
  public UsernameAlreadyExistsException(String username) {
    super(String.format("User with username: %s already exists", username));
  }

}
