package az.edu.turing.tinderapplication.service.impl;

import az.edu.turing.tinderapplication.domain.model.dto.UserDto;
import az.edu.turing.tinderapplication.domain.model.entity.UserEntity;
import az.edu.turing.tinderapplication.domain.repository.UserRepository;
import az.edu.turing.tinderapplication.mapper.UserMapper;
import az.edu.turing.tinderapplication.service.UserService;
import jakarta.servlet.http.HttpSession;
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
    public List<UserDto> getLikedUsers(HttpSession session) {
        UserDto curr = (UserDto) session.getAttribute("currentUser");
        List<UserEntity> allUsers = userRepository.getAll();
        List<UserDto> allUserDto = new ArrayList<>();
        allUsers.forEach(userEntity -> allUserDto.add(UserMapper.INSTANCE.toDto(userEntity)));
        allUserDto.removeIf(userDto -> userDto.getId() == curr.getId());
        return allUserDto.stream().filter(UserDto::isLiked).toList();
    }

    @Override
    public UserDto findUserById(UUID id) {
        return UserMapper.INSTANCE.toDto(userRepository.getById(id));
    }

    @Override
    public List<UserDto> getAllUsers() {
        List <UserDto> users = new ArrayList<>();
        userRepository.getAll().forEach(userEntity -> users.add(UserMapper.INSTANCE.toDto(userEntity)));
        return users;
    }
}
