package com.nexus.users.controllers;

import com.nexus.users.entities.UserEntity;
import com.nexus.users.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<UserEntity>> readUserById(@PathVariable String id) {
        Optional<UserEntity> userFound = this.userService.readUserById(id);
        return new ResponseEntity<Optional<UserEntity>>(userFound, null, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> readAllUsers() {
        List<UserEntity> users = this.userService.readAllUsers();

        return new ResponseEntity<List<UserEntity>>(users, null, HttpStatus.FOUND);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @Valid @RequestBody UserEntity user) {
        this.userService.updateUser(id, user);
        return new ResponseEntity<String>("User Updated Succesfully", null, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        this.userService.deleteUser(id);
        return new ResponseEntity<String>("User deleted succesfully", null, HttpStatus.OK);
    }

}
