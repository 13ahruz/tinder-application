package az.edu.turing.tinderapplication.controller;

import az.edu.turing.tinderapplication.domain.model.dto.UserDto;
import az.edu.turing.tinderapplication.service.LikeService;
import az.edu.turing.tinderapplication.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/v1")
public class MatchController {
    private final UserService userService;
    private final LikeService likeService;

    private int currentIndex = 0;

    @GetMapping("/match")
    public String toMatchPage(Model model, HttpSession session) {
        UserDto currentUser = (UserDto) session.getAttribute("currentUser");
        List<UserDto> users = userService.getAllUsers();
        if (!users.isEmpty()) {
//            if (users.get(currentIndex).getId() == currentUser.getId()){
//                currentIndex = (currentIndex + 1) % users.size();
//            }
            model.addAttribute("user", users.get(currentIndex));
        } else {
            model.addAttribute("message", "No users available");
        }
        return "like-page";
    }

    @PostMapping("/match/like")
    public String likeUser(Model model, HttpSession session) {
        UserDto currentUser = (UserDto) session.getAttribute("currentUser");
        List<UserDto> users = userService.getAllUsers();

        // Filter out the current user from the list
        users.removeIf(user -> user.getId().equals(currentUser.getId()));

        if (!users.isEmpty()) {
            likeService.likeUserById(users.get(currentIndex).getId());
            currentIndex = (currentIndex + 1) % users.size();
            session.setAttribute("currentIndex", currentIndex);
            model.addAttribute("user", users.get(currentIndex));
        } else {
            model.addAttribute("message", "No users available");
        }
        return "like-page";
    }

    @PostMapping("/match/dislike")
    public String dislikeUser(Model model, HttpSession session) {
        UserDto currentUser = (UserDto) session.getAttribute("currentUser");
        List<UserDto> users = userService.getAllUsers();

        // Filter out the current user from the list
        users.removeIf(user -> user.getId().equals(currentUser.getId()));

        if (!users.isEmpty()) {
            likeService.dislikeUserById(users.get(currentIndex).getId());
            currentIndex = (currentIndex + 1) % users.size();
            session.setAttribute("currentIndex", currentIndex);
            model.addAttribute("user", users.get(currentIndex));
        } else {
            model.addAttribute("message", "No users available");
        }
        return "like-page";
    }
}
