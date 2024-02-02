package com.example.Coder.Request;

import java.util.Set;

public class UserRegisterRequest {
    private String Username;
    private String email;
    private String password;
    private String Role;
    private Set<Long> roleId;


    public UserRegisterRequest() {
    }

    

    public UserRegisterRequest(String username, String email, String password, String role, Set<Long> roleId) {
        Username = username;
        this.email = email;
        this.password = password;
        Role = role;
        this.roleId = roleId;
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



    public Set<Long> getRoleId() {
        return roleId;
    }



    public void setRoleId(Set<Long> roleId) {
        this.roleId = roleId;
    }
    

}
