package az.edu.turing.tinderapplication.service;

import az.edu.turing.tinderapplication.domain.model.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserDto> getLikedUsers();


    UserDto findUserById (UUID id);

    List<UserDto> getAllUsers ();
}