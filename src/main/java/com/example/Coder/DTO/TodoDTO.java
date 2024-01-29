package com.example.Coder.DTO;

import java.time.LocalDateTime;

public class TodoDTO {
    private Long id;
    private long todolistId;
    private String name;
    private String description;
    private String todoKey;
    private Boolean isArchived;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public TodoDTO() {
    }

    public TodoDTO(Long id,Long todolistId, String name, String description, String todoKey, Boolean isArchived,
            LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.todolistId=todolistId;
        this.name = name;
        this.description = description;
        this.todoKey = todoKey;
        this.isArchived = isArchived;

        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTodoKey() {
        return todoKey;
    }

    public void setTodoKey(String todoKey) {
        this.todoKey = todoKey;
    }

    public Boolean getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Boolean isArchived) {
        this.isArchived = isArchived;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public long getTodolistId() {
        return todolistId;
    }

    public void setTodolistId(long todolistId) {
        this.todolistId = todolistId;
    }

}
