package com.example.besttest.models.entities;

import com.example.besttest.models.baseEntities.TimestampedEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "test_solutions")
public class TestSolution extends TimestampedEntity {

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private Testing test;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private int score;
    private String answers;

    public TestSolution(Testing test, User user, int score, String answers) {
        this.test = test;
        this.user = user;
        this.score = score;
        this.answers = answers;
    }

    public TestSolution() {
    }

    public void setTest(Testing test) {
        this.test = test;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public Testing getTest() {
        return test;
    }
    public String getAnswers() {
        return answers;
    }
    @Column(nullable = false)
    public int getScore() {
        return score;
    }

    public User getUser() {
        return user;
    }
}