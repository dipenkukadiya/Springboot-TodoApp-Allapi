package com.example.Coder.DTO;

public class CommentDTO {
    private String comment;
    private String todoName;
    private String userName;
    public CommentDTO() {
    }
    public CommentDTO(String comment, String todoName, String userName) {
        this.comment = comment;
        this.todoName = todoName;
        this.userName = userName;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getTodoName() {
        return todoName;
    }
    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
