package az.edu.turing.tinderapplication.service;

import java.util.UUID;

public interface LikeService {
    boolean likeUserById (UUID id);
    boolean dislikeUserById (UUID id);
}
