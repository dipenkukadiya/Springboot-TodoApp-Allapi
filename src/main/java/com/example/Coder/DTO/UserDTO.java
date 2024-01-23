package com.example.Coder.DTO;

public class UserDTO {

    private String Username;
    private String email;
    private String Role;
    private String Descreption;

    public UserDTO() {
    }

    public UserDTO(String username, String email, String role, String descreption) {
        Username = username;
        this.email = email;
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
