package com.example.Coder.Service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Coder.Auhtentication.JwtUtil;
import com.example.Coder.DTO.UserDTO;

import com.example.Coder.Entity.User;
import com.example.Coder.Entity.UserRole;
import com.example.Coder.Repository.RoleRepo;
import com.example.Coder.Repository.UserRepo;
import com.example.Coder.Repository.UserRoleRepo;
import com.example.Coder.Request.UserLoginRequest;
import com.example.Coder.Request.UserRegisterRequest;
import com.example.Coder.Request.UserUpdateRequest;
import com.example.Coder.Service.UserAuthService;

@Service
public class UserAuthServiceimpl implements UserAuthService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    UserRoleRepo userRoleRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepo roleRepo;

    @Override
    public void addUser(UserRegisterRequest userRegisterRequest) {
        User user = new User();

        user.setUsername(userRegisterRequest.getUsername());
        user.setEmail(userRegisterRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterRequest.getPassword()));
        user.setRole(userRegisterRequest.getRole());
     LocalDateTime currentDateTime = LocalDateTime.now();
        user.setCreatedDate(currentDateTime);
        user.setUpdatedDate(currentDateTime);

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
    public List<UserDTO> getUsers() {
        List<User> users = userRepo.findAll();

        List<UserDTO> userDTOs = convertToUserDTOList(users);

        return userDTOs;
    }

    private List<UserDTO> convertToUserDTOList(List<User> users) {
        List<UserDTO> userDTOs = new ArrayList<>();

        for (User user : users) {
            UserDTO userDTO = convertUserToDTO(user);
            userDTOs.add(userDTO);
        }

        return userDTOs;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepo.findById(userId).orElse(null);

        if (user != null) {
            return convertUserToDTO(user);
        }
        return null;
    }

    private UserDTO convertUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        // UserRole userRole = new UserRole();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());

        UserRole userRole = userRoleRepo.findByRoleName(user.getRole());

        if (userRole != null) {
            userDTO.setDescreption(userRole.getDescription());
        } else {

            userDTO.setDescreption("Role description not available");
        }

        return userDTO;
    }

    @Override
    public void updateUser(UserUpdateRequest userUpdateRequest, Long userId) {
        User user = userRepo.findById(userId).orElse(null);
        System.out.println("hello update");
        if (user != null) {
            user.setUsername(userUpdateRequest.getUsername());
            user.setPassword(passwordEncoder.encode(userUpdateRequest.getPassword()));
            user.setEmail(userUpdateRequest.getEmail());
           
      
          
            userRepo.save(user);

        }

    }

    @Override
    public void removeUser(Long userId) {
        userRepo.deleteById(userId);

    }

    // @Override
    // public User getUserByemail(String email) {
    // return userRepo.findByemail(email);
    // }
}
