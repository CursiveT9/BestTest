package com.example.besttest.dtos;

import java.util.HashMap;
import java.util.Map;

public class UserCreatedTestDTO {

    private String userId;
    private String testId;

    public UserCreatedTestDTO(String userId, String testId) {
        this.userId = userId;
        this.testId = testId;
    }

    public UserCreatedTestDTO() {
    }

    private final Map<String, Action> actions = new HashMap<>();
    public Map<String, Action> getActions() {
        return actions;
    }
    public void addAction(String rel, Action action) {
        this.actions.put(rel, action);
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getUserId() {
        return userId;
    }
    public String getTestId() {
        return testId;
    }

}
