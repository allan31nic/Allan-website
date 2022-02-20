package alla.web.emailConfig;

import javax.mail.MessagingException;
import java.io.IOException;

public interface SmtpMail {

    void send(String to) throws MessagingException, IOException;
}
