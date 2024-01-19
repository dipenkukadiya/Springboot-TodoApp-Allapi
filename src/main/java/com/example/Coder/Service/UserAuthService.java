package com.example.Coder.Service;

import java.util.List;

import com.example.Coder.Entity.User;
import com.example.Coder.Request.UserRegisterRequest;
import com.example.Coder.Request.UserLoginRequest;

public interface UserAuthService {
    void addUser(UserRegisterRequest userRegisterRequest);

    String loginUser(UserLoginRequest userLoginRequest);

    User getByToken(String token);
  
    List<User> getUsers();
    // User getUserByemail(String email);

}
