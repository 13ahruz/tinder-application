package az.edu.turing.tinderapplication.service.impl;

import az.edu.turing.tinderapplication.domain.model.dto.UserDto;
import az.edu.turing.tinderapplication.domain.model.entity.UserEntity;
import az.edu.turing.tinderapplication.domain.repository.UserRepository;
import az.edu.turing.tinderapplication.mapper.UserMapper;
import az.edu.turing.tinderapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getLikedUsers() {
        List<UserEntity> allUsers = userRepository.getAll();
        List<UserDto> allUserDto = new ArrayList<>();
        allUsers.forEach(userEntity -> allUserDto.add(UserMapper.INSTANCE.toDto(userEntity)));
        return allUserDto.stream().filter(UserDto::isLiked).toList();
    }

    @Override
    public UserDto getNextUser(UserDto userDto) {
        return null;
    }

    @Override
    public boolean addToLikedUsers(UserDto userDto) {
        return true;
    }

    @Override
    public UserDto findUserById(UUID id) {
        return UserMapper.INSTANCE.toDto(userRepository.getById(id));
    }
}
