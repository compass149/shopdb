package org.pgm.shopserver.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pgm.shopserver.model.Role;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    @Column(name = "username", unique = true, nullable = false, length = 100)
    private String username;
    private String password;
    private String name;
    private LocalDateTime createTime;
    private Role role;
}
