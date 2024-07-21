package az.edu.turing.tinderapplication.service.impl;

import az.edu.turing.tinderapplication.domain.repository.AuthRepository;
import az.edu.turing.tinderapplication.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;


    @Override
    public ResponseEntity<String> login(String username) {
        return null;
    }

    @Override
    public boolean isAuthenticate(String username, String password) {
        return authRepository.authenticate(username, password);
    }
}
