package az.edu.turing.tinderapplication.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class UserDto {
    private UUID id;
    private String username;
    private String fullName;
    private LocalDateTime lastLoginAt;
    private LocalDateTime lastActiveAt;
    private String profilePhoto;
    private String password;
    private boolean liked;
}