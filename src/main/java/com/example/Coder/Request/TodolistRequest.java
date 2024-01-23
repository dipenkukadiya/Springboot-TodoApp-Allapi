package com.example.Coder.Request;

public class TodolistRequest {
    private String name;
    private String todolistKey;
    private Long todolistIndex;
    private boolean isArchive;
    public TodolistRequest() {
    }
    
    public TodolistRequest(String name, String todolistKey, Long todolistIndex, boolean isArchive) {
        this.name = name;
        this.todolistKey = todolistKey;
        this.todolistIndex = todolistIndex;
        this.isArchive = isArchive;
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