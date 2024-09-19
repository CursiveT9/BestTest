package com.example.besttest.services;

import com.example.besttest.dtos.UserDTO;
import com.example.besttest.dtos.output.UserOutputDTO;
import com.example.besttest.enums.UserRoleType;
import com.example.besttest.models.entities.User;
import com.example.besttest.services.internal.InternalUserService;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(UserDTO userDTO);
    void deleteUser(String userId);
    List<UserDTO> findUsersByRole(UserRoleType roleType);

    UserDTO getUserByUsername(String username);

    UserDTO getUserDTOById(String id);

    List<UserOutputDTO> getUserOutputDTO();

    UserOutputDTO getUserOutputDTOById(String id);

    @Transactional
    UserDTO editUser(String id, UserDTO userDTO);

    User getUserById(String userId);

}
