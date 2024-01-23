
package com.example.Coder.DTO;

public class BoardDTO {
    private Long id;
    private String title;
    private String description;
    private boolean isFavorite;
  

    public BoardDTO() {
    }

    public BoardDTO(Long id, String title, String description, boolean isFavorite) {
        this.id = id;
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

  
    
}