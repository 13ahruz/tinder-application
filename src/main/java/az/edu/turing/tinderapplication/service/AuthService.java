package az.edu.turing.tinderapplication.service;

import az.edu.turing.tinderapplication.domain.model.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<String> login(String username);

    boolean isAuthenticate(String username, String password);

    UserDto getUserByUsername (String username);
}
