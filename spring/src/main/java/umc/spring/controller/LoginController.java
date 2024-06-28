package umc.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String login() {
        return "login";
    }

    @GetMapping("/success")
    public ModelAndView loginSuccess(@RequestParam String id) {
        ModelAndView mav = new ModelAndView("login-success");
        mav.addObject("id", id);
        return mav;
    }
}