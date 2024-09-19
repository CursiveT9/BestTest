package com.example.besttest.models.entities;

import com.example.besttest.converters.RoleTypeConverter;
import com.example.besttest.enums.UserRoleType;
import com.example.besttest.models.baseEntities.BaseEntity;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "user_roles")
public class UserRole extends BaseEntity {

    private UserRoleType role;
    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

    public UserRole(UserRoleType role) {
        this.role = role;
    }

    public UserRole() {
    }

    public void setRole(UserRoleType role) {
        this.role = role;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Convert(converter = RoleTypeConverter.class)
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "role", length = 9, nullable = false)
    public UserRoleType getRole() {
        return role;
    }
    public List<User> getUsers() {
        return users;
    }
}
