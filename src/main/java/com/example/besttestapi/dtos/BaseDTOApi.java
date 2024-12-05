package com.example.besttestapi.dtos;

import org.springframework.hateoas.RepresentationModel;
import java.util.HashMap;
import java.util.Map;

public class BaseDTOApi extends RepresentationModel<BaseDTOApi> {
    private String id;

    public BaseDTOApi(String id) {
        this.id = id;
    }

    public BaseDTOApi() {
    }

    private final Map<String, ActionApi> actions = new HashMap<>();
    public Map<String, ActionApi> getActions() {
        return actions;
    }
    public void addAction(String rel, ActionApi action) {
        this.actions.put(rel, action);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public BaseDTOApi add(org.springframework.hateoas.Link selfLink) {
        return super.add(selfLink);
    }
}
