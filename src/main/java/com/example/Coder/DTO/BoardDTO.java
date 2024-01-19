
package com.example.Coder.DTO;

public class BoardDTO {
    private Long id;
    private String title;
    private String description;
    private boolean favorite;
  

    public BoardDTO() {
    }

    public BoardDTO(Long id, String title, String description, boolean favorite) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.favorite = favorite;
       
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

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    
}