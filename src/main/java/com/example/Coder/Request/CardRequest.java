package com.example.Coder.Request;

public class CardRequest {
    private String name;
    private String cardKey;
    private Long cardIndex;
    private boolean archive;
    public CardRequest() {
    }
    public CardRequest(String name, String cardKey, Long cardIndex, boolean archive) {
        this.name = name;
        this.cardKey = cardKey;
        this.cardIndex = cardIndex;
        this.archive = archive;
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