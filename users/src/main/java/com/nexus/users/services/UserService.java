package com.nexus.users.services;

import com.nexus.users.entities.UserEntity;
import com.nexus.users.repositories.IUserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void createUser(UserEntity user) {
        try {
            this.userRepository.save(
                    UserEntity.builder()
                            .name(user.getName())
                            .email(user.getEmail())
                            .currency(user.getCurrency())
                            .password(this.passwordEncoder.encode(user.getPassword()))
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<UserEntity> readUserById(String id) {
        try {
            return this.userRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<UserEntity> readUserByEmailAndPassword(String email, String password) {
        try {
            Optional<UserEntity> userFound = this.userRepository.findUserByEmail(email);
            boolean matches = this.passwordEncoder.matches(password, userFound.get().getPassword());
            return matches ? userFound : Optional.empty();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserEntity> readAllUsers() {
        try {
            return this.userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(String id, UserEntity user) {
        try {
            UserEntity userFound = this.userRepository.findById(id).orElse(null);
            assert userFound != null;
            userFound.setName(user.getName() == null ? userFound.getName() : user.getName());
            userFound.setEmail(user.getEmail() == null ? userFound.getEmail() : user.getEmail());
            userFound.setCurrency(user.getCurrency() == null ? userFound.getCurrency() : user.getCurrency());
            userFound.setPassword(user.getPassword() == null ? userFound.getPassword()
                    : this.passwordEncoder.encode(user.getPassword()));

            this.userRepository.save(userFound);
        } catch (Exception error) {
            throw new RuntimeException(error);
        }
    }

    public void deleteUser(String id) {
        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
