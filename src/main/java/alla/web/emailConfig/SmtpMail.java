package alla.web.emailConfig;

import javax.mail.MessagingException;

public interface SmtpMail {

    void send(String to) throws MessagingException;
}
