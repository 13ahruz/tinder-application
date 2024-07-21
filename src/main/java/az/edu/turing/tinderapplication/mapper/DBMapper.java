package az.edu.turing.tinderapplication.mapper;

import az.edu.turing.tinderapplication.domain.model.entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DBMapper {

    public static UserEntity mapResultSetToUserEntity(ResultSet resultSet) throws SQLException {
        UserEntity user = new UserEntity();
        user.setId((UUID) resultSet.getObject("id"));
        user.setUsername(resultSet.getString("username"));
        user.setFullName(resultSet.getString("full_name"));
        user.setLastActiveAt(resultSet.getTimestamp("last_active").toLocalDateTime());
        user.setLastLoginAt(resultSet.getTimestamp("last_login").toLocalDateTime());
        user.setProfilePhoto(resultSet.getString("profile_photo"));
        user.setLiked(resultSet.getBoolean("liked"));
        return user;
    }

    public static List<UserEntity> mapResultSetToUserEntityList(ResultSet resultSet) throws SQLException {
        List<UserEntity> userList = new ArrayList<>();
        while (resultSet.next()) {
            userList.add(mapResultSetToUserEntity(resultSet));
        }
        return userList;
    }
}
