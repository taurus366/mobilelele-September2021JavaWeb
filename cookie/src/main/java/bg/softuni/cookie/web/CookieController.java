package bg.softuni.cookie.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    @GetMapping("/cookies")
    public String cookies(@CookieValue(name = "lang", defaultValue = "en") String lang, Model model) {
        model.addAttribute("lang", lang);
        return "cookies";
    }

    @PostMapping("/cookies")
    public String cookiesPost(@RequestParam String lang2, HttpServletResponse response) {

        Cookie langCookie = new Cookie("lang", lang2);
        response.addCookie(langCookie);

        System.out.println("Preferred user language is : " + lang2);
        return "redirect:/cookies";
    }
}
