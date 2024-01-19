package com.example.Coder.DTO;

public class CardDTO {
    
    private Long id;
    private String name;
    private String cardKey;
    private Long cardIndex;
    private boolean archive;
    public CardDTO() {
    }
    public CardDTO(Long id, String name, String cardKey, Long cardIndex, boolean archive) {
        this.id = id;
        this.name = name;
        this.cardKey = cardKey;
        this.cardIndex = cardIndex;
        this.archive = archive;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCardKey() {
        return cardKey;
    }
    public void setCardKey(String cardKey) {
        this.cardKey = cardKey;
    }
    public Long getCardIndex() {
        return cardIndex;
    }
    public void setCardIndex(Long cardIndex) {
        this.cardIndex = cardIndex;
    }
    public boolean isArchive() {
        return archive;
    }
    public void setArchive(boolean archive) {
        this.archive = archive;
    }
    
}