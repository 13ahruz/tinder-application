package az.edu.turing.tinderapplication.service;

import java.util.UUID;

public interface LikeService {
    void likeUserById (UUID id);
    void dislikeUserById (UUID id);
}
