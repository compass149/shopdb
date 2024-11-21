package org.pgm.shopserver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.pgm.shopserver.model.User;
import org.pgm.shopserver.service.AuthenticationService;
import org.pgm.shopserver.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authentication")
@RequiredArgsConstructor
@Log4j2
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("sign-up")
    public ResponseEntity signUp(@RequestBody User user) {
        log.info("Authentication Controller user +=" + user);
    }
}
