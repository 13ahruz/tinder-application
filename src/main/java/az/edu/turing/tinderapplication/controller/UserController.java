package az.edu.turing.tinderapplication.controller;

import az.edu.turing.tinderapplication.domain.model.dto.UserDto;
import az.edu.turing.tinderapplication.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@AllArgsConstructor
@Controller
@RequestMapping("api/v1")
public class UserController {
    private final UserService userService;

    @GetMapping("/liked")
    public String likedUsers(Model model) {
        model.addAttribute("users", userService.getLikedUsers());
        return "liked";
    }

    @GetMapping("/users/{id}")
    public String message(@PathVariable UUID id, Model model){
        UserDto userDto = userService.findUserById(id);
        System.out.println(userDto.toString());
        model.addAttribute("user", userDto);
        return "chat";
    }

    @GetMapping("/next")
    public UserDto getNextUser(@PathVariable("next") UserDto userDto) {
        return userService.getNextUser(userDto);
    }

    @PostMapping("/add")
    public boolean addToLikedUsers(UserDto userDto) {
        return userService.addToLikedUsers(userDto);
    }
}