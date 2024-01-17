package com.example.Coder.Service;

import com.example.Coder.Entity.User;
import com.example.Coder.Request.UserRequest;

public interface UserAuthService {
    void addRegisterUser(User user);
    String loginUser(UserRequest userdto);
    // User getUserByemail(String email);
    // List<User> getUsers();
    
    
}

