package org.pgm.shopserver.service;

import lombok.RequiredArgsConstructor;
import org.pgm.shopserver.dto.UserDTO;
import org.pgm.shopserver.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO findByUsername(String username) {
        return null;
    }

    @Override
    public void changeRole(Role newRole, String username) {

    }

    @Override
    public List<UserDTO> findAllUsers() {
        return List.of();
    }
}
