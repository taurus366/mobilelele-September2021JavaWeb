package bg.softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/register")
    public String register(){
        return "register";
    }

//    @PostMapping("/register")
//    public String registerConfirm(@Valid UserRegisterBindingDto userRegisterBindingDto, BindingResult bindingResult){
//
//        return "reddirect:/";
//    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


}
