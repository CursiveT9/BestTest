package com.example.besttest.services.Security;

import com.example.besttest.dtos.input.UserRegistrationDTO;
import com.example.besttest.enums.UserRoleType;
import com.example.besttest.models.entities.UserRole;
import com.example.besttest.repositories.UserRepository;
import com.example.besttest.repositories.UserRoleRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.besttest.models.entities.User;

import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;

    private UserRoleRepository userRoleRepository;

//    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    public void register(UserRegistrationDTO registrationDTO) {

        Optional<User> byUserName = this.userRepository.findByUsername(registrationDTO.getUsername());

        if (byUserName.isPresent()) {
            throw new RuntimeException("userName.used");
        }

        UserRole userRole = userRoleRepository.
                findByRole(UserRoleType.USER).orElseThrow();

//        User user = new User(
//                registrationDTO.getUsername(),
//                passwordEncoder.encode(registrationDTO.getPassword()),
//                registrationDTO.getFirstName(),
//                registrationDTO.getLastName(),
//                true,
//                "",
//                userRole
//        );

//        this.userRepository.save(user);
    }

    public User getUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.get();
    }
}