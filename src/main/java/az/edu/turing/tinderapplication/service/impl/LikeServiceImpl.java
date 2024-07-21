package az.edu.turing.tinderapplication.service.impl;

import az.edu.turing.tinderapplication.domain.repository.LikeRepository;
import az.edu.turing.tinderapplication.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;

    @Override
    public boolean likeUserById(UUID id) {
        return likeRepository.likeUserById(id);
    }

    @Override
    public boolean dislikeUserById(UUID id) {
        return likeRepository.dislikeUserById(id);
    }
}
