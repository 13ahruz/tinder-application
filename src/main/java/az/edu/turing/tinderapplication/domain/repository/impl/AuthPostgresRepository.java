package az.edu.turing.tinderapplication.domain.repository.impl;

import az.edu.turing.tinderapplication.config.PostgresConfig;
import az.edu.turing.tinderapplication.domain.model.entity.UserEntity;
import az.edu.turing.tinderapplication.domain.repository.AuthRepository;
import az.edu.turing.tinderapplication.mapper.DBMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository
public class AuthPostgresRepository implements AuthRepository {
    Connection conn = new PostgresConfig().getConnection();

    @Override
    public boolean authenticate(String username, String password) {
        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM USERS WHERE username = ? AND password = ?", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM USERS WHERE username = ?")) {
            statement.setString(1, username);
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
}
