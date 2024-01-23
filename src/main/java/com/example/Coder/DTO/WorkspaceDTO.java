package com.example.Coder.DTO;

public class WorkspaceDTO {

    private Long id;
    private String title;
    private String description;
    private boolean isPrivate;

    public WorkspaceDTO() {
    }

    public WorkspaceDTO(Long id, String title, String description, boolean isPrivate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isPrivate = isPrivate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }


}
