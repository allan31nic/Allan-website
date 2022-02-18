package alla.web.emailConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class SmtpImple implements SmtpMail{
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void send(String to) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setSubject("resume");
        helper.setTo(to);
        helper.setText("Allan Collado Raudez", true);

        javaMailSender.send(message);

    }
}
