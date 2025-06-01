package com.nexus.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String id;

    @NotBlank(message = "Name shouldn't be empty")
    private String name;

    @NotBlank(message = "Email shouldn't be empty")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Password shouldn't be empty")
    private String password;

    @NotBlank(message = "Currency shouldn't be empty")
    private String currency;
}
