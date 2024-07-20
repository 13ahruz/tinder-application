package az.edu.turing.tinderapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor

public class UserDto {
    private String username;
    private String fullname;
    private LocalDateTime lastLoginAt;
    private LocalDateTime lastActive;
}