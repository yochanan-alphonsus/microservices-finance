package com.nexus.users.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "users_tbl")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", unique = true, nullable = false)
    private String id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Email(message = "Please, provide a valid email")
    @Column(name = "user_email", unique = true, nullable = false)
    private String email;

    @Size(min = 8, message = "A password must contain at least 8 characters")
    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_currency", nullable = false)
    private String currency;

    @CreatedDate
    @Column(name = "user_created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "user_updated_at", updatable = true, nullable = false)
    private LocalDateTime updatedAt;
}
