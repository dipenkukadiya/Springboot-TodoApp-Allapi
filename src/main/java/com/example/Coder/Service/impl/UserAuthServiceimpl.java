package com.example.Coder.Service.impl;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Coder.Auhtentication.JwtUtil;
import com.example.Coder.Entity.User;
import com.example.Coder.Repository.UserRepo;
import com.example.Coder.Request.UserRequest;
import com.example.Coder.Service.UserAuthService;

@Service
public class UserAuthServiceimpl implements UserAuthService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    JwtUtil jwtUtil;

    @Override
    public void addRegisterUser(User user) {
        userRepo.save(user);

    }

    @Override
    public String loginUser(UserRequest userDto) {
        try {
            User user = userRepo.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
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

    // @Override
    // public User getUserByemail(String email) {
    // return userRepo.findByemail(email);
    // }

    // @Override
    // public List<User> getUsers() {
    // return userRepo.findAll();

    // }

}
