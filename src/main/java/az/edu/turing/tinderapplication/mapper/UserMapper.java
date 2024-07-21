package az.edu.turing.tinderapplication.mapper;

import az.edu.turing.tinderapplication.domain.model.dto.UserDto;
import az.edu.turing.tinderapplication.domain.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper (componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "lastLoginAt", target = "lastLoginAt")
    @Mapping(source = "lastActiveAt", target = "lastActiveAt")
    @Mapping(source = "profilePhoto", target = "profilePhoto")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "liked", target = "liked")
    UserDto toDto(UserEntity entity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "lastLoginAt", target = "lastLoginAt")
    @Mapping(source = "lastActiveAt", target = "lastActiveAt")
    @Mapping(source = "profilePhoto", target = "profilePhoto")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "liked", target = "liked")
    UserEntity toEntity(UserDto dto);
}
