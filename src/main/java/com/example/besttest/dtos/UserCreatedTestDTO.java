package com.example.besttest.dtos;

public class UserCreatedTestDTO extends BaseDTO{

    private String userId;
    private String testId;

    public UserCreatedTestDTO(String userId, String testId) {
        this.userId = userId;
        this.testId = testId;
    }

    public UserCreatedTestDTO() {
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
