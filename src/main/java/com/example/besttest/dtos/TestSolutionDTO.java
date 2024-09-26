package com.example.besttest.dtos;

public class TestSolutionDTO extends BaseDTO{

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
