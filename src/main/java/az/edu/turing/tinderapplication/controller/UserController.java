package az.edu.turing.tinderapplication.controller;

import az.edu.turing.tinderapplication.model.UserDto;
import az.edu.turing.tinderapplication.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public List<UserDto> getLikedUsers() {
        return userService.getLikedUsers();
    }

    @GetMapping("/next")
    public UserDto getNextUser(@PathVariable ("next") UserDto userDto) {
        return userService.getNextUser(userDto);
    }

    @PostMapping("/add")
    public boolean addToLikedUsers(UserDto userDto) {
        return userService.addToLikedUsers(userDto);
    }
}