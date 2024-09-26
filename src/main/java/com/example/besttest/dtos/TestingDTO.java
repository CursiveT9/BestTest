package com.example.besttest.dtos;

import com.example.besttest.enums.AccessLevel;

public class TestingDTO extends BaseDTO{

    private String title;
    private String description;
    private String creatorId;
    private AccessLevel accessLevel;
    private String testContentUrl;
    private int points;
    private String articleId;

    public TestingDTO(String title, String description, String creatorId, AccessLevel accessLevel, String testContentUrl, int points, String articleId) {
        this.title = title;
        this.description = description;
        this.creatorId = creatorId;
        this.accessLevel = accessLevel;
        this.testContentUrl = testContentUrl;
        this.points = points;
        this.articleId = articleId;
    }

    public TestingDTO() {
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setTestContentUrl(String testContentUrl) {
        this.testContentUrl = testContentUrl;
    }
    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getTitle() {
        return title;
    }
    public String getArticleId() {
        return articleId;
    }
    public int getPoints() {
        return points;
    }
    public String getTestContentUrl() {
        return testContentUrl;
    }
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }
    public String getCreatorId() {
        return creatorId;
    }
    public String getDescription() {
        return description;
    }
}
