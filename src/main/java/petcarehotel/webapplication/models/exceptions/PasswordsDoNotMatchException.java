package petcarehotel.webapplication.models.exceptions;

/**
 * Custom exception for not matching passwords.
 */
public class PasswordsDoNotMatchException extends RuntimeException {
  public PasswordsDoNotMatchException() {
    super("Passwords do not match exception.");
  }

}
