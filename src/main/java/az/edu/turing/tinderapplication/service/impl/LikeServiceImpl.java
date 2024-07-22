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
    public void likeUserById(UUID id) {
        likeRepository.likeUserById(id);
    }

    @Override
    public void dislikeUserById(UUID id) {
        likeRepository.dislikeUserById(id);
    }
}
