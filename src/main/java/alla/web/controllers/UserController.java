package alla.web.controllers;

import alla.web.emailConfig.SmtpMail;
import alla.web.model.UserInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;


@Controller
public class UserController {

   @Autowired
   private SmtpMail smtpMail;

    @GetMapping({"/", "/home"})
    public String home(){
        return "index";
    }

    @GetMapping("/resume")
    public String resume(Model model){
        UserInf userInfo = new UserInf();
        model.addAttribute("send", userInfo );
        return "form";
    }
    @PostMapping("/send")
    public String sendEmail(@ModelAttribute UserInf userInf) throws MessagingException {
        smtpMail.send(userInf.getEmail());
        return "redirect:/home";
    }

}
