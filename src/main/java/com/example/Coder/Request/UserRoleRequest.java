package com.example.Coder.Request;


public class UserRoleRequest {
   
    private String roleName;
    
    private String Description;
    public UserRoleRequest() {
    }
    public UserRoleRequest(String roleName,  String description) {
        this.roleName = roleName;
     
        Description = description;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
   
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    
    
}
