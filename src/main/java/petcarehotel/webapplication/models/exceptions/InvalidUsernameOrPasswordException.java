package petcarehotel.webapplication.models.exceptions;

/**
 * Custom exception for invalid username or password.
 */
public class InvalidUsernameOrPasswordException extends RuntimeException {
  public InvalidUsernameOrPasswordException() {
    super("Invalid username or password exception");
  }
}
