package com.movietix.user.config;

import com.movietix.user.entity.Role;
import com.movietix.user.entity.User;
import com.movietix.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            log.info("Seeding user database...");
            List<User> users = Arrays.asList(
                User.builder()
                    .name("Admin User")
                    .email("admin@example.com")
                    .password(passwordEncoder.encode("secret123"))
                    .role(Role.ROLE_ADMIN)
                    .build(),
                User.builder()
                    .name("John Doe")
                    .email("john@example.com")
                    .password(passwordEncoder.encode("secret123"))
                    .role(Role.ROLE_CUSTOMER)
                    .build()
            );
            userRepository.saveAll(users);
            log.info("Successfully seeded {} default users", users.size());
        } else {
            log.info("User database already contains data. Skipping seeding.");
        }
    }
}
