package az.edu.turing.tinderapplication.domain.repository;

import az.edu.turing.tinderapplication.domain.model.dto.UserDto;
import az.edu.turing.tinderapplication.domain.model.entity.UserEntity;

public interface AuthRepository {

    boolean authenticate (String username, String password);

    UserEntity getUserByUsername(String username);
}
