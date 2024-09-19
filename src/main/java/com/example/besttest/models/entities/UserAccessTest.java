package com.example.besttest.models.entities;

import com.example.besttest.enums.AccessLevel;
import com.example.besttest.models.baseEntities.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "user_access_tests")
public class UserAccessTest extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private Testing test;

    public UserAccessTest(User user, Testing test) {
        this.user = user;
        this.test = test;
    }

    public UserAccessTest() {
    }

    public void setUser(User user) {
        this.user = user;
    }
    public void setTest(Testing test) {
        this.test = test;
    }

    public User getUser() {
        return user;
    }
    public Testing getTest() {
        return test;
    }
}
