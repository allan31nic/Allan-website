package alla.web.controllers.emailConfig;

public interface SmtpMail {

    void send(String to, String subject, String body);
}
