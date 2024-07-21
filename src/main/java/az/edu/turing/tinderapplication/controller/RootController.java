package az.edu.turing.tinderapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String redirectToApi() {
        return "redirect:/api/v1/login";
    }
}
