package petcarehotel.webapplication.config.email;

import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * Implementation of the EmailService.
 */
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

  private final JavaMailSender mailSender;

  /**
   * Method to send email for verification.
   *
   * @param mail Mail
   */
  public void sendEmail(Mail mail) {
    MimeMessage mimeMessage = mailSender.createMimeMessage();

    try {

      MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

      mimeMessageHelper.setSubject(mail.getMailSubject());
      mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom(), "petcare.com"));
      mimeMessageHelper.setTo(mail.getMailTo());
      mimeMessageHelper.setText(mail.getMailContent(), true);

      mailSender.send(mimeMessageHelper.getMimeMessage());

    } catch (MessagingException | UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
