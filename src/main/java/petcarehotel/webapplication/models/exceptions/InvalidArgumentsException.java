package petcarehotel.webapplication.models.exceptions;

/**
 * Custom exception for invalid arguments.
 */
public class InvalidArgumentsException extends RuntimeException {
  public InvalidArgumentsException() {
    super("Invalid arguments exception");
  }

}
