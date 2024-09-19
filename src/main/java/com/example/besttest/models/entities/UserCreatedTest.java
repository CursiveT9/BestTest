package com.example.besttest.models.entities;

import com.example.besttest.models.baseEntities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_created_tests")
public class UserCreatedTest extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private Testing test;

    public UserCreatedTest(User user, Testing test) {
        this.user = user;
        this.test = test;
    }

    public UserCreatedTest() {
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