package com.example.backendeksamen3semester.service;

import com.example.backendeksamen3semester.model.User;
import com.example.backendeksamen3semester.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public class UserService {

    public final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User verifyLogin(User user) throws LoginException {
        return userRepository.findByUsernamePasswordMatch(user.getUsername(), user.getPassword()).orElseThrow(() -> new LoginException("Incorrect details"));
    }
}
