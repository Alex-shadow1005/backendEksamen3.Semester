package com.example.backendeksamen3semester.controller;

import com.example.backendeksamen3semester.model.User;
import com.example.backendeksamen3semester.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;


@RestController
@CrossOrigin //tillader at man bruger klassen i et andet origin (javascript)
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/verify")
    public ResponseEntity<User> verifyLogin(@RequestBody User user) throws LoginException {
        User userVerified = userService.verifyLogin(user);
        return new ResponseEntity<>(userVerified, HttpStatus.OK);
    }
}
