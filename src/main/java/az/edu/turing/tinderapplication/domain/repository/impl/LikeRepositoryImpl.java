package az.edu.turing.tinderapplication.domain.repository.impl;

import az.edu.turing.tinderapplication.config.PostgresConfig;
import az.edu.turing.tinderapplication.domain.repository.LikeRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

@Repository
public class LikeRepositoryImpl implements LikeRepository {

    Connection conn = new PostgresConfig().getConnection();

    @Override
    public boolean likeUserById(UUID id) {
        try (PreparedStatement statement = conn.prepareStatement("UPDATE USERS SET liked = TRUE WHERE id = ?")) {
            statement.setObject(1, id);
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean dislikeUserById(UUID id) {
        try (PreparedStatement statement = conn.prepareStatement("UPDATE USERS SET liked = FALSE WHERE id = ?")) {
            statement.setObject(1, id);
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
