package az.edu.turing.tinderapplication.controller;

import az.edu.turing.tinderapplication.domain.model.dto.UserDto;
import az.edu.turing.tinderapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public String message(@PathVariable UUID id, Model model){
        UserDto userDto = userService.findUserById(id);
        model.addAttribute("user", userDto);
        return "chat";
    }
}
