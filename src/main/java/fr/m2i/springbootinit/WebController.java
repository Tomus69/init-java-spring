package fr.m2i.springbootinit;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebController {

    @GetMapping("/index")
    public String index(HttpSession session, Model model) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        session.setAttribute("date", simpleDateFormat.format(date));
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/index")
    public String indexSubmit(@ModelAttribute User user, Model model) {
        boolean isValidEmail = UserSecurity.checkEmail(user.getEmail());
        if (!isValidEmail) {
            user.setValidEmail(false);
            return "index";
        }
        UserManager userManager = new UserManager();
        userManager.getUserList().add(user.getUserName());
        model.addAttribute("userList", userManager.getUserList());
        return "result";
    }
}
