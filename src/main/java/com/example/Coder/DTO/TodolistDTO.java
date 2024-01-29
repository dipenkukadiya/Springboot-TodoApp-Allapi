package com.example.Coder.DTO;

public class TodolistDTO {
    
    private Long id;
    private Long boardId;
    private String name;
    private String todolistKey;
    private Long todolistIndex;
    private boolean isArchive;
    public TodolistDTO() {
    }
    
    public TodolistDTO(Long id,Long boardId, String name, String todolistKey, Long todolistIndex, boolean isArchive) {
        this.id = id;
        this.boardId=boardId;
        this.name = name;
        this.todolistKey = todolistKey;
        this.todolistIndex = todolistIndex;
        this.isArchive = isArchive;
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

    public String getTodolistKey() {
        return todolistKey;
    }

    public void setTodolistKey(String todolistKey) {
        this.todolistKey = todolistKey;
    }

    public Long getTodolistIndex() {
        return todolistIndex;
    }

    public void setTodolistIndex(Long todolistIndex) {
        this.todolistIndex = todolistIndex;
    }

    public boolean getIsArchive() {
        return isArchive;
    }

    public void setIsArchive(boolean isArchive) {
        this.isArchive = isArchive;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

   
    
}