package az.edu.turing.tinderapplication.controller;

import az.edu.turing.tinderapplication.domain.model.LoginRequest;
import az.edu.turing.tinderapplication.exception.InvalidUserException;
import az.edu.turing.tinderapplication.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/v1")

public class AuthController {

    private final AuthService authService;

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }


    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (isAuthenticate(username, password)) {
            return new ModelAndView("redirect:/api/v1/index");
        } else {
            throw new InvalidUserException("Invalid username or password!");
        }
    }

    private boolean isAuthenticate(String username, String password) {
        return authService.isAuthenticate(username, password);
    }
}
