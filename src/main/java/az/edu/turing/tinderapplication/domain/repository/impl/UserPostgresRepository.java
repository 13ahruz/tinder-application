package az.edu.turing.tinderapplication.domain.repository.impl;

import az.edu.turing.tinderapplication.config.PostgresConfig;
import az.edu.turing.tinderapplication.domain.model.entity.UserEntity;
import az.edu.turing.tinderapplication.domain.repository.UserRepository;
import az.edu.turing.tinderapplication.mapper.DBMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserPostgresRepository implements UserRepository {

    Connection conn = new PostgresConfig().getConnection();

    @Override
    public Boolean save(UserEntity userEntity) {
        try (PreparedStatement query = conn.prepareStatement("INSERT INTO users (fullname, username) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            query.setString(1, userEntity.getFullName());
            query.setString(2, userEntity.getUsername());
            int affectedRows = query.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<UserEntity> getAll() {
        List<UserEntity> userEntities = new ArrayList<>();
        try (PreparedStatement query = conn.prepareStatement("SELECT id, username, full_name, last_login, last_active, password, profile_photo, liked FROM users ")) {
            ResultSet resultSet = query.executeQuery();
            while (resultSet.next()) {
                userEntities.add(DBMapper.mapResultSetToUserEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userEntities;
    }

    @Override
    public UserEntity getById(UUID id) {
        try (PreparedStatement statement = conn.prepareStatement("SELECT id, username, full_name, last_login, last_active, password, profile_photo, liked FROM USERS WHERE id = ?")) {
            statement.setObject(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return DBMapper.mapResultSetToUserEntity(resultSet);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean deleteById(UUID id) {
        return null;
    }
}

