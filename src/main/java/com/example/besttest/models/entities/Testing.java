package com.example.besttest.models.entities;

import com.example.besttest.enums.AccessLevel;
import com.example.besttest.models.baseEntities.TimestampedEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "tests")
public class Testing extends TimestampedEntity {

    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User user;
    private AccessLevel accessLevel;
    private String testContentUrl;
    private int points;
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    public Testing(String title, String description, User user, String content, AccessLevel accessLevel, int points, Article article) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.testContentUrl = content;
        this.accessLevel = accessLevel;
        this.points = points;
        this.article = article;
    }

    public Testing() {
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCreator(User user) {
        this.user = user;
    }
    public void setContent(String content) {
        this.testContentUrl = content;
    }
    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public void setArticle(Article article) {
        this.article = article;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }
    public Article getArticle() {
        return article;
    }
    @Column(nullable = false)
    public int getPoints() {
        return points;
    }
    @Column(name = "testContentUrl", nullable = false)
    public String getContent() {
        return testContentUrl;
    }
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "access_level", length = 9, nullable = false)
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }
    public User getUser() {
        return user;
    }
    @Column(name = "discription", nullable = false)
    public String getDescription() {
        return description;
    }
}