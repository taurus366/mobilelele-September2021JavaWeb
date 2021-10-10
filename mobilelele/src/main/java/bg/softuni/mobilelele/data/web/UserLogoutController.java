package bg.softuni.mobilelele.data.web;

import bg.softuni.mobilelele.data.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLogoutController {

    private final UserService userService;

    public UserLogoutController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/logout")
    public String logout() {
        userService.logOut();
        return "redirect:/";

    }
}
