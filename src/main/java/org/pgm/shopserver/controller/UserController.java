package org.pgm.shopserver.controller;

import lombok.RequiredArgsConstructor;
import org.pgm.shopserver.model.Role;
import org.pgm.shopserver.security.UserPrinciple;
import org.pgm.shopserver.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:300*")

public class UserController {
    private final UserService userService;

    @PutMapping("/change/{role}")
    public ResponseEntity<Object> changeRole(@AuthenticationPrincipal UserPrinciple userPrinciple,
                                             @PathVariable Role role) {
        userService.changeRole(role,userPrinciple.getUsername());
        return ResponseEntity.ok(true);
    }
}
