package com.example.Coder.Request;


public class UserRoleRequest {
   
    private String roleName;
    private String roleKey;
    private String Description;
    public UserRoleRequest() {
    }
    public UserRoleRequest(String roleName, String roleKey, String description) {
        this.roleName = roleName;
        this.roleKey = roleKey;
        Description = description;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getRoleKey() {
        return roleKey;
    }
    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    
    
}
