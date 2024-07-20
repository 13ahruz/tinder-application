package az.edu.turing.tinderapplication.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserEntity {
    private Long id;
    private String username;
    private String fullname;
    private String profilePhoto;
    private LocalDateTime lastLoginAt;
    private LocalDateTime lastActive;

    public UserEntity(Long id, String username, String fullname) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
    }
}
