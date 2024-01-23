package com.example.Coder.DTO;

public class TodolistDTO {
    
    private Long id;
    private String name;
    private String todolistKey;
    private Long todolistIndex;
    private boolean isArchive;
    public TodolistDTO() {
    }
    
    public TodolistDTO(Long id, String name, String todolistKey, Long todolistIndex, boolean isArchive) {
        this.id = id;
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

   
    
}