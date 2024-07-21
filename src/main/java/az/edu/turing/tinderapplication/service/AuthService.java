package az.edu.turing.tinderapplication.service;

import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<String> login(String username);

    boolean isAuthenticate(String username, String password);
}
