package com.example.Coder.Service;

import java.util.List;

import com.example.Coder.DTO.UserDTO;
import com.example.Coder.Entity.User;
import com.example.Coder.Request.UserLoginRequest;
import com.example.Coder.Request.UserRegisterRequest;
import com.example.Coder.Request.UserUpdateRequest;

public interface UserAuthService {
    void addUser(UserRegisterRequest userRegisterRequest);

    String loginUser(UserLoginRequest userLoginRequest);

    User getByToken(String token);

    List<UserDTO> getUsers();
    
    UserDTO getUserById(Long user_id);
    
    void updateUser(UserUpdateRequest userUpdateRequest, Long user_id);
    
    void removeUser(Long user_id);
    
    // User getUserByemail(String email);
}
