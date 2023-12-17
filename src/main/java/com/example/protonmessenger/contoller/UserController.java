package com.example.protonmessenger.contoller;

import com.example.protonmessenger.model.User;
import com.example.protonmessenger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    Iterable<User> all() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    User save(@RequestBody User user) {
        return userRepository.save(user);
    }

}