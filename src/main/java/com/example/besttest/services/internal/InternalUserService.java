package com.example.besttest.services.internal;

import com.example.besttest.models.entities.User;

public interface InternalUserService {
    User getUserById(String userId);
}