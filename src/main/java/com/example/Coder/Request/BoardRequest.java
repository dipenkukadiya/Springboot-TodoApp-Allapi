package com.example.Coder.Request;

public class BoardRequest {
    private String title;
    private String description;
    private Boolean favorite;
  

    public BoardRequest() {
    }

    public BoardRequest(String title, String description, Boolean favorite) {
        this.title = title;
        this.description = description;
        this.favorite = favorite;
    
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

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

 

}
