package petcarehotel.webapplication.models.exceptions;

/**
 * Custom exception for invalid email.
 */
public class InvalidEmailException extends RuntimeException {
  public InvalidEmailException() {
    super("Invalid email exception");
  }
}
