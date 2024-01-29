
package com.example.Coder.DTO;

public class BoardDTO {
    private Long id;
    private Long workspaceId;
    private String title;
    private String description;
    private boolean isFavorite;
  

    public BoardDTO() {
    }

    public BoardDTO(Long id, Long workspaceId,String title, String description, boolean isFavorite) {
        this.id = id;
        this.workspaceId= workspaceId;
        this.title = title;
        this.description = description;
        this.isFavorite = isFavorite;
       
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

    public boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Long getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
    }

  
    
}