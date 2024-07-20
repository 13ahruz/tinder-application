package az.edu.turing.tinderapplication.service;

import az.edu.turing.tinderapplication.model.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getLikedUsers();

    UserDto getNextUser(UserDto userDto);

    boolean addToLikedUsers(UserDto userDto);
}