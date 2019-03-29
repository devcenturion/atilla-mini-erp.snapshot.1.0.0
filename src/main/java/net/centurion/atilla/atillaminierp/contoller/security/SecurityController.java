package net.centurion.atilla.atillaminierp.contoller.security;

import net.centurion.atilla.atillaminierp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController{

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/login")
    public String login ( ) {
        return "login";
    }


    @RequestMapping("/")
    public String home ( ) {

        return "redirect:/home";
    }
}
