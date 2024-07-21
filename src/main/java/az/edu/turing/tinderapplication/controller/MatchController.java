package az.edu.turing.tinderapplication.controller;

import az.edu.turing.tinderapplication.domain.model.dto.UserDto;
import az.edu.turing.tinderapplication.domain.repository.UserRepository;
import az.edu.turing.tinderapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/v1")
public class MatchController {
    private final UserService userService;

    private int currentIndex = 0;

    @GetMapping("/match")
    public String toMatchPage(Model model) {
        List<UserDto> users = userService.getAllUsers(); // Assuming you have this method in your UserService
        if (!users.isEmpty()) {
            model.addAttribute("user", users.get(currentIndex));
        } else {
            model.addAttribute("message", "No users available");
        }
        return "like-page";
    }

    @PostMapping("/match/like")
    public String likeUser(Model model) {
        List<UserDto> users = userService.getAllUsers();
        if (!users.isEmpty()) {
            currentIndex = (currentIndex + 1) % users.size();
            model.addAttribute("user", users.get(currentIndex));
        } else {
            model.addAttribute("message", "No users available");
        }
        return "like-page";
    }

    @PostMapping("/match/dislike")
    public String dislikeUser(Model model) {
        List<UserDto> users = userService.getAllUsers();
        if (!users.isEmpty()) {
            currentIndex = (currentIndex + 1) % users.size();
            model.addAttribute("user", users.get(currentIndex));
        } else {
            model.addAttribute("message", "No users available");
        }
        return "like-page";
    }
}
