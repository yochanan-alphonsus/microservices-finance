package com.nexus.users.repositories;

import com.nexus.users.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, String> {
    public Optional<UserEntity> findUserByEmail(String email);
}
