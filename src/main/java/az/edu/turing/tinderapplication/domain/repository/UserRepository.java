package az.edu.turing.tinderapplication.domain.repository;

import az.edu.turing.tinderapplication.domain.model.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserRepository {
    Boolean save(UserEntity userEntity);

    List<UserEntity> getAll();

    UserEntity getById(UUID id);

    Boolean deleteById(UUID id);
}
