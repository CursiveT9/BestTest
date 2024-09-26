package com.example.besttest.dtos;

import com.example.besttest.enums.AccessLevel;
import java.util.HashMap;
import java.util.Map;

public class ArticleDTO extends BaseDTO {

    private String title;
    private String articlesContentUrl;
    private AccessLevel accessLevel;

    public ArticleDTO(String title, String articlesContentUrl, AccessLevel accessLevel) {
        this.title = title;
        this.articlesContentUrl = articlesContentUrl;
        this.accessLevel = accessLevel;
    }

    public ArticleDTO() {
    }

    private final Map<String, Action> actions = new HashMap<>();
    public Map<String, Action> getActions() {
        return actions;
    }
    public void addAction(String rel, Action action) {
        this.actions.put(rel, action);
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

    public String getTitle() {
        return title;
    }
    public String getContentUrl() {
        return articlesContentUrl;
    }
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

}
