package az.edu.turing.tinderapplication.domain.model.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Data
public class UserEntity {
    private UUID id;
    private String username;
    private String fullName;
    private LocalDateTime lastLoginAt;
    private LocalDateTime lastActiveAt;
    private String profilePhoto;
    private String password;
    private boolean liked;
}
