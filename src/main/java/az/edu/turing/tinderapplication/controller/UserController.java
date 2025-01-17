package az.edu.turing.tinderapplication.controller;

import az.edu.turing.tinderapplication.domain.model.dto.UserDto;
import az.edu.turing.tinderapplication.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@AllArgsConstructor
@Controller
@RequestMapping("api/v1")
public class UserController {
    private final UserService userService;
    HttpSession session;

    @GetMapping("/liked")
    public String likedUsers(Model model) {
        model.addAttribute("users", userService.getLikedUsers(session));
        return "liked";
    }

    @GetMapping("/users/{id}")
    public String message(@PathVariable UUID id, Model model) {
        UserDto userDto = userService.findUserById(id);
        model.addAttribute("user", userDto);
        return "chat";
    }
}