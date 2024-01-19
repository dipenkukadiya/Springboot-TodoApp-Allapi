package com.example.Coder.Service.impl;

import java.util.List;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Coder.Auhtentication.JwtUtil;
import com.example.Coder.Entity.User;
import com.example.Coder.Repository.UserRepo;
import com.example.Coder.Request.UserRegisterRequest;
import com.example.Coder.Request.UserLoginRequest;
import com.example.Coder.Service.UserAuthService;

@Service
public class UserAuthServiceimpl implements UserAuthService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    JwtUtil jwtUtil;

    @Override
    public void addUser(UserRegisterRequest userRegisterRequest) {
        User user = new User();
        user.setUsername(userRegisterRequest.getUsername());
        user.setEmail(userRegisterRequest.getEmail());
        user.setPassword(userRegisterRequest.getPassword());
        user.setCreatedDate(userRegisterRequest.getCreatedDate());
        user.setUpdatedDate(userRegisterRequest.getUpdatedDate());
        userRepo.save(user);

    }

    @Override
    public String loginUser(UserLoginRequest userLoginRequest) {
        try {
            User user = userRepo.findByEmailAndPassword(userLoginRequest.getEmail(), userLoginRequest.getPassword());
            if (user != null) {

                return jwtUtil.generateToken(user.getEmail());
            }
            return null;
        } catch (Exception e) {

            return null;
        }
    }

    @Override
    public User getByToken(String token) {
        String email = jwtUtil.getEmailFromToken(token);
        if (email != null) {
            return userRepo.findByemail(email);
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();

    }
    // @Override
    // public User getUserByemail(String email) {
    // return userRepo.findByemail(email);
    // }

}
