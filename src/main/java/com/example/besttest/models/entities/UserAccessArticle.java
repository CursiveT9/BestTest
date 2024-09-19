package com.example.besttest.models.entities;

import com.example.besttest.models.baseEntities.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "user_access_articles")
public class UserAccessArticle extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable=false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "article_id", nullable=false)
    private Article article;

    public UserAccessArticle(User user, Article article) {
        this.user = user;
        this.article = article;
    }

    public UserAccessArticle() {
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    public void setArticle(Article article) {
        this.article = article;
    }

}
