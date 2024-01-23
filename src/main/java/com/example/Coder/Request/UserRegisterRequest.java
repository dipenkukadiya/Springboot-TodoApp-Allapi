package com.example.Coder.Request;

import java.sql.Date;

public class UserRegisterRequest {
    private String Username;
    private String email;
    private String password;
    private String Role;
    private Date createdDate;
    private Date updatedDate;

    public UserRegisterRequest() {
    }

    public UserRegisterRequest(String username, String email, String password, String role, Date createdDate,
            Date updatedDate) {
        Username = username;
        this.email = email;
        this.password = password;
        this.Role=role;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

}
