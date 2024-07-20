package az.edu.turing.tinderapplication.domain.repository;

import az.edu.turing.tinderapplication.domain.entity.UserEntity;

import java.util.List;
import java.util.function.Predicate;

public interface UserRepository {
    Boolean save(UserEntity userEntity);
    List<UserEntity> findAll();
    List<UserEntity> findBy(Predicate predicate);
    Boolean deleteById (Long id);
}
