package petcarehotel.webapplication.config.email;

import java.util.function.Predicate;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

/**
 * Service for validating the Email.
 */
@Service
public class EmailValidator implements Predicate<String> {

  /**
   * Testing the email that was found on input.
   *
   * @param s String
   * @return boolean
   */
  @Override
  public boolean test(String s) {
    String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    return Pattern.compile(regexPattern).matcher(s).matches();
  }
}
