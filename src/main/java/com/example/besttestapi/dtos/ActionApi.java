package com.example.besttestapi.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActionApi {
    private String href;
    private String method;
    private String accept;

    public ActionApi(String href, String method, String accept) {
        this.href = href;
        this.method = method;
        this.accept = accept;
    }

    public ActionApi(String href, String method) {
        this.href = href;
        this.method = method;
    }

    public void setHref(String href) {
        this.href = href;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getHref() {
        return href;
    }
    public String getMethod() {
        return method;
    }
    public String getAccept() {
        return accept;
    }
}
