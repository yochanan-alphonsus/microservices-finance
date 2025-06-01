package com.nexus.users.controllers;

import com.nexus.users.entities.UserEntity;
import com.nexus.users.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody UserEntity user) {
        this.userService.createUser(user);
        return new ResponseEntity<String>("User Created Succesfully", null, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Optional<UserEntity>> readUserByEmailAndPassword(@Valid @RequestBody UserEntity user) {
        Optional<UserEntity> userFound = this.userService.readUserByEmailAndPassword(user.getEmail(),
                user.getPassword());

        return new ResponseEntity<Optional<UserEntity>>(userFound, null, HttpStatus.FOUND);
    }

}
