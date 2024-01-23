package com.example.Coder.DTO;



public class UserDTO {
    private Long id;
    private String Username;
    private String email;
    private String Role;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, String email, String role) {
        this.id = id;
        Username = username;
        this.email = email;
        Role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    

}
