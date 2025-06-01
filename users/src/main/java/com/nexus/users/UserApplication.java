package com.nexus.users;

import com.nexus.users.entities.UserEntity;
import com.nexus.users.repositories.IUserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableDiscoveryClient
@EnableJpaAuditing
@Configuration
@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(IUserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            userRepository.save(UserEntity.builder().name("Yochanan").email("yocha@gmail.com")
                    .password(passwordEncoder.encode("12345678"))
                    .currency("GBP")
                    .build());

            userRepository.save(UserEntity.builder().name("John Doe").email("johndoe@gmail.com")
                    .password(passwordEncoder.encode("abcdefgh"))
                    .currency("EUR")
                    .build());
        };
    }

}
