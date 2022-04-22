package petcarehotel.webapplication.config.email;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Class Mail.
 */
@Getter
@Setter
@AllArgsConstructor
public class Mail {

  private String mailFrom;

  private String mailTo;

  private String mailCc;

  private String mailBcc;

  private String mailSubject;

  private String mailContent;

  private String contentType;

  private List<Object> attachments;

  public Mail() {
    contentType = "text/plain";
  }

}