package com.example.besttest.dtos.input;

import com.example.besttest.enums.UserRoleType;
import jakarta.validation.constraints.NotNull;

public class UserRoleDTO {
    private String id;
    private UserRoleType role;

    public UserRoleDTO(UserRoleType role) {
        this.role = role;
    }
    public UserRoleDTO() {
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setRole(UserRoleType role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }
    @NotNull(message = "Role cannot be null")
    public UserRoleType getRole() {
        return role;
    }
}