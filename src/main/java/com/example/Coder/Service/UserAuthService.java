package com.example.Coder.Service;

// import java.util.List;

import com.example.Coder.DTO.UserDto;
import com.example.Coder.Entity.User;

public interface UserAuthService {
    void addRegisterUser(User user);
    String loginUser(UserDto userdto);
    // User getUserByemail(String email);
    // List<User> getUsers();
    
    
}

