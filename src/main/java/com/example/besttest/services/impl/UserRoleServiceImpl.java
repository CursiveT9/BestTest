package com.example.besttest.services.impl;

import com.example.besttest.dtos.UserRoleDTO;
import com.example.besttest.enums.UserRoleType;
import com.example.besttest.models.entities.UserRole;
import com.example.besttest.repositories.UserRoleRepository;
import com.example.besttest.services.UserRoleService;
import com.example.besttest.services.internal.InternalRoleService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService, InternalRoleService {
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository, ModelMapper modelMapper) {
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public UserRoleDTO createUserRole(UserRoleDTO userRoleDTO) {
        UserRole userRole = modelMapper.map(userRoleDTO, UserRole.class);
        UserRole savedUserRole = userRoleRepository.save(userRole);
        return modelMapper.map(savedUserRole, UserRoleDTO.class);
    }

    @Override
    public UserRoleDTO getUserRoleById(String id) {
        Optional<UserRole> userRoleOptional = userRoleRepository.findById(id);

        if (userRoleOptional.isPresent()) {
            return modelMapper.map(userRoleOptional.get(), UserRoleDTO.class);
        } else {
            throw new EntityNotFoundException("User role not found with id: " + id);
        }
    }

    @Override
    public List<UserRoleDTO> getAllUserRoles() {
        List<UserRole> userRoles = userRoleRepository.findAll();
        return userRoles.stream()
                .map(userRole -> modelMapper.map(userRole, UserRoleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteUserRole(String id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    public UserRole findByRole(UserRoleType roleType) {
        UserRole userRole = userRoleRepository.findByRole(roleType)
                .orElseThrow(() -> new EntityNotFoundException("User role not found: " + roleType));
        return userRole;
    }

    @Override
    public List<UserRoleDTO> findAll() {
        return userRoleRepository.findAll().stream().map(e -> modelMapper.map(e, UserRoleDTO.class)).collect(Collectors.toList());
    }
}