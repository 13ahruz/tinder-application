package az.edu.turing.tinderapplication.service.impl;

import az.edu.turing.tinderapplication.model.UserDto;
import az.edu.turing.tinderapplication.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<UserDto> getLikedUsers() {
        return null;
    }

    @Override
    public UserDto getNextUser(UserDto userDto) {
        return null;
    }

    @Override
    public boolean addToLikedUsers(UserDto userDto) {
        return true;
    }
}
