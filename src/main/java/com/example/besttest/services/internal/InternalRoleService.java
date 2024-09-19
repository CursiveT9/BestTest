package com.example.besttest.services.internal;

import com.example.besttest.enums.UserRoleType;
import com.example.besttest.models.entities.UserRole;

public interface InternalRoleService {
    UserRole findByRole (UserRoleType roleType);
}
