package petcarehotel.webapplication.models.exceptions;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException() {
        super("Invalid email exception");
    }
}
