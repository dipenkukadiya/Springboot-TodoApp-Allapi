package com.example.Coder.Request;

public class UserUpdateRequest {
    private String Username;
    private String email;
    private String password;
    private String Role;
    private String Descreption;

    
    public UserUpdateRequest() {
    }
    
    public UserUpdateRequest(String username, String email, String password, String role, String descreption) {
        Username = username;
        this.email = email;
        this.password = password;
        Role = role;
        Descreption = descreption;
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

    public String getDescreption() {
        return Descreption;
    }

    public void setDescreption(String descreption) {
        Descreption = descreption;
    }

}
