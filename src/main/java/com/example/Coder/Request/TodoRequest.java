package com.example.Coder.Request;

import java.util.Set;

public class TodoRequest {
    private String name;
    private String description;
    private String todoKey;
    private Boolean isArchived;
    private Set<Long> assignedToIds;
    private Long createdById;

    public TodoRequest() {
    }

  
    public TodoRequest(String name, String description, String todoKey, Boolean isArchived, Set<Long> assignedToIds,
            Long createdById) {
        this.name = name;
        this.description = description;
        this.todoKey = todoKey;
        this.isArchived = isArchived;
        this.assignedToIds = assignedToIds;
        this.createdById = createdById;
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

    

    public Set<Long> getAssignedToIds() {
        return assignedToIds;
    }


    public void setAssignedToIds(Set<Long> assignedToIds) {
        this.assignedToIds = assignedToIds;
    }


    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }

}
