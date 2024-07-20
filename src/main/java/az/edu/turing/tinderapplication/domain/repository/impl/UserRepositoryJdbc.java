package az.edu.turing.tinderapplication.domain.repository.impl;

import az.edu.turing.tinderapplication.domain.entity.UserEntity;
import az.edu.turing.tinderapplication.domain.repository.UserRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UserRepositoryJdbc implements UserRepository {
    @Override
    public Boolean save(UserEntity userEntity) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5555/postgres",
                "postgres",
                "postgres");
             PreparedStatement query = conn.prepareStatement("INSERT INTO user (fullname, username) VALUES (?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            query.setString(1, userEntity.getFullname());
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
    public List<UserEntity> findAll() {
        List<UserEntity> userEntities = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5555/postgres",
                "postgres",
                "postgres");
             PreparedStatement query = conn.prepareStatement("SELECT user_id, username, fullname FROM booking ")) {
            ResultSet resultSet = query.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("user_id");
                String username = resultSet.getString("username");
                String fullname = resultSet.getString("fullname");
                userEntities.add(new UserEntity(id, username, fullname));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userEntities;
    }

    @Override
    public List<UserEntity> findBy(Predicate predicate) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }
}
