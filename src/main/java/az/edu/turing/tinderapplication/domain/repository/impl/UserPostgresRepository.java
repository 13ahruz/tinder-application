package az.edu.turing.tinderapplication.domain.repository.impl;

import az.edu.turing.tinderapplication.config.PostgresConfig;
import az.edu.turing.tinderapplication.domain.model.entity.UserEntity;
import az.edu.turing.tinderapplication.domain.repository.UserRepository;
import az.edu.turing.tinderapplication.mapper.DBMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

@Repository
public class UserPostgresRepository implements UserRepository {

    //TODO Write all fields to queries
    Connection conn = new PostgresConfig().getConnection();

    @Override
    public Boolean save(UserEntity userEntity) {
        try (PreparedStatement query = conn.prepareStatement("INSERT INTO users (fullname, username) VALUES (?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {
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
//                String username = resultSet.getString("username");
//                String fullName = resultSet.getString("full_name");
//                LocalDateTime lastLoginAt = (resultSet.getTimestamp("last_login").toLocalDateTime());
//                LocalDateTime lastActiveAt = (resultSet.getTimestamp("last_active").toLocalDateTime());
//                String profilePhoto = resultSet.getString("profile_photo");
//                boolean liked = resultSet.getBoolean("liked");
//                UserEntity userEntity = new UserEntity();
//                userEntity.setUsername(username);
//                userEntity.setFullName(fullName);
//                userEntity.setLastLoginAt(lastLoginAt);
//                userEntity.setLastActiveAt(lastActiveAt);
//                userEntity.setProfilePhoto(profilePhoto);
//                userEntity.setLiked(liked);
//                userEntities.add(userEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userEntities;
    }

    @Override
    public UserEntity getById(UUID id) {
        try (PreparedStatement statement = conn.prepareStatement("SELECT FROM USERS WHERE id = ?")){
            ResultSet resultSet = statement.executeQuery();
            return DBMapper.mapResultSetToUserEntity(resultSet);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean deleteById(UUID id) {
        return null;
    }
    }

    //TODO UPDATE TABLE AND FIELD NAMES WHILE COPYING FROM OTHER PROJECTS. (UPDATED SOME OF THEM)
//    @Override
//    public List<UserEntity> getAll() {
//        List<UserEntity> userEntities = new ArrayList<>();
//        try (PreparedStatement query = conn.prepareStatement("SELECT username, fullname, profile_photo FROM users ")) {
//            ResultSet resultSet = query.executeQuery();
//            while (resultSet.next()) {
//                String username = resultSet.getString("username");
//                String fullName = resultSet.getString("full_name");
//                LocalDateTime lastLoginAt = (resultSet.getTimestamp("last_login").toLocalDateTime());
//                LocalDateTime lastActiveAt = (resultSet.getTimestamp("last_active").toLocalDateTime());
//                String profilePhoto = resultSet.getString("profile_photo");
//                UserEntity userEntity = new UserEntity();
//                userEntity.setUsername(username);
//                userEntity.setFullName(fullName);
//                userEntity.setLastLoginAt(lastLoginAt);
//                userEntity.setLastActiveAt(lastActiveAt);
//                userEntity.setProfilePhoto(profilePhoto);
//                userEntities.add(userEntity);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return userEntities;
//    }
