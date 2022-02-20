package alla.web.emailConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

@Component
public class SmtpImple implements SmtpMail{
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void send(String to) throws MessagingException, IOException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        ClassPathResource pdf = new ClassPathResource("static/myresume.pdf");
        helper.setFrom("Allan30nic@outlook.com");
        helper.setSubject("resume");
        helper.setTo(to);
        helper.setText("Thank you for taking your time to check out my profile.", true);
        helper.addAttachment("myresume.pdf", pdf);

        javaMailSender.send(message);


    }
}
