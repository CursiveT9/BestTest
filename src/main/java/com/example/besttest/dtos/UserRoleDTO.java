package com.example.besttest.dtos;

import com.example.besttest.enums.UserRoleType;
import jakarta.validation.constraints.NotNull;

public class UserRoleDTO extends BaseDTO {

    private UserRoleType role;

    public UserRoleDTO(UserRoleType role) {
        this.role = role;
    }
    public UserRoleDTO() {
    }

    public void setRole(UserRoleType role) {
        this.role = role;
    }

    @NotNull(message = "Role cannot be null")
    public UserRoleType getRole() {
        return role;
    }
}