package az.edu.turing.tinderapplication.domain.repository;

import java.util.UUID;

public interface LikeRepository {
    boolean likeUserById (UUID id);
    boolean dislikeUserById (UUID id);

}
