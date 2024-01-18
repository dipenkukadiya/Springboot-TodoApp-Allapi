package com.example.Coder.Request;

public class WorkspaceRequest {
    private String title;
    private String description;
    private Boolean isPrivate;

    public WorkspaceRequest() {
    }

    public WorkspaceRequest(String title, String description, Boolean isPrivate) {
        this.title = title;
        this.description = description;
        this.isPrivate = isPrivate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

}
