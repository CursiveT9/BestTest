package com.example.besttest.services.impl;

import com.example.besttest.dtos.UserDTO;
import com.example.besttest.dtos.output.UserOutputDTO;
import com.example.besttest.enums.UserRoleType;
import com.example.besttest.models.entities.User;
import com.example.besttest.models.entities.UserRole;
import com.example.besttest.repositories.UserRepository;
import com.example.besttest.repositories.UserRoleRepository;
import com.example.besttest.services.UserService;
import com.example.besttest.services.internal.InternalRoleService;
import com.example.besttest.services.internal.InternalUserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, InternalUserService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final InternalRoleService internalRoleService;
//    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRoleRepository userRoleRepository, UserRepository userRepository, ModelMapper modelMapper, InternalRoleService internalRoleService) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.internalRoleService = internalRoleService;
//        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);

        UserRole userRole = userRoleRepository.findByRole(userDTO.getRole())
                .orElseThrow(() -> new EntityNotFoundException("User role not found: " + userDTO.getRole()));
        user.setRole(userRole);
        user.setPassword(userDTO.getPassword());
//        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User existingUser = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userDTO.getId()));

        existingUser.setUsername(userDTO.getUsername());
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setActive(userDTO.getActive());
        existingUser.setImageUrl(userDTO.getImageUrl());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setPoints(userDTO.getPoints());
        existingUser.setRole(internalRoleService.findByRole(userDTO.getRole()));

        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserDTO.class);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDTO> findUsersByRole(UserRoleType roleType) {
        List<User> users = userRepository.findByRole_Role(roleType);
        List<UserDTO> userDTO = users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
        return userDTO;
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        Optional user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UserNotFoundException(username);
//        }
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO getUserDTOById(String id) {
        Optional<User> user = userRepository.findById(id);
//                .orElseThrow(() -> new UserNotFoundException(id));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserOutputDTO> getUserOutputDTO() {
        return List.of();
    }

    @Override
    public UserOutputDTO getUserOutputDTOById(String id) {
        return null;
    }

    @Override
    public User getUserById(String userId) {
        Optional<User> user = userRepository.findById(userId);
//                .orElseThrow(() -> new UserNotFoundException(userId));
        return user.orElse(null);
    }

    @Override
    public UserDTO editUser(String id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        UserRole userRole = userRoleRepository.findByRole(userDTO.getRole())
                .orElseThrow(() -> new EntityNotFoundException("CarModel not found: " + userDTO.getRole()));
        existingUser.setRole(userRole);
        existingUser.setActive(userDTO.getActive());
        existingUser.setUsername(userDTO.getUsername());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setImageUrl(userDTO.getImageUrl());
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setPassword(userDTO.getPassword());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setPoints(userDTO.getPoints());

        User updatedUser = userRepository.save(existingUser);

        return modelMapper.map(updatedUser, UserDTO.class);
    }

}
