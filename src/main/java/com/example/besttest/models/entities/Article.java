package com.example.besttest.models.entities;

import com.example.besttest.enums.AccessLevel;
import com.example.besttest.models.baseEntities.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "articles")
public class Article extends BaseEntity {

    private String title;
    private String articlesContentUrl;
    private AccessLevel accessLevel;

    public Article(String title, String contentUrl, AccessLevel accessLevel) {
        this.title = title;
        this.articlesContentUrl = contentUrl;
        this.accessLevel = accessLevel;
    }

    public Article() {
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setContentUrl(String contentUrl) {
        this.articlesContentUrl = contentUrl;
    }
    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Column(nullable = false)
    public String getTitle() {
        return title;
    }
    public String getContentUrl() {
        return articlesContentUrl;
    }
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "access_level", length = 9, nullable = false)
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }
}
