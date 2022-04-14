package petcarehotel.webapplication.models.exceptions;

/**
 * Custom exception for invalid user credentials.
 */
public class InvalidUserCredentialsException extends RuntimeException {
  public InvalidUserCredentialsException() {
    super("Invalid user credentials exception");
  }

}
