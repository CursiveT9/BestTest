package com.example.besttest.dtos;

import java.util.HashMap;
import java.util.Map;

public class TestSolutionDTO {

    private String testId;
    private String userId;
    private int score;
    private String answers;

    public TestSolutionDTO(String testId, String userId, int score, String answers) {
        this.testId = testId;
        this.userId = userId;
        this.score = score;
        this.answers = answers;
    }

    public TestSolutionDTO() {
    }

    private final Map<String, Action> actions = new HashMap<>();
    public Map<String, Action> getActions() {
        return actions;
    }
    public void addAction(String rel, Action action) {
        this.actions.put(rel, action);
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getTestId() {
        return testId;
    }
    public int getScore() {
        return score;
    }
    public String getUserId() {
        return userId;
    }
    public String getAnswers() {
        return answers;
    }
}
