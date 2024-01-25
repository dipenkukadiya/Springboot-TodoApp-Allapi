package com.example.Coder.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Coder.Entity.UserRole;
import com.example.Coder.Repository.UserRoleRepo;
import com.example.Coder.Request.UserRoleRequest;
import com.example.Coder.Service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepo userRoleRepo;

    @Override
    public void addUserRole(UserRoleRequest userRoleRequest) {
        UserRole userRole = new UserRole();
        userRole.setRoleName(userRoleRequest.getRoleName());
        userRole.setRoleKey(userRoleRequest.getRoleKey());
        userRole.setDescription(userRoleRequest.getDescription());

        userRoleRepo.save(userRole);
    }

    @Override
    public List<UserRole> getAllUserRoles() {
        List<UserRole> userRoles = new ArrayList<>();
        userRoleRepo.findAll().forEach(userRoles::add);
        return userRoles;
    }

    @Override
    public UserRole getUserRoleById(Long userRoleId) {
        UserRole userRole = userRoleRepo.findById(userRoleId).orElse(null);
        if (userRole != null) {
            return userRole;
        }
        return null;
    }

    @Override
    public void updateUserRole(UserRoleRequest userRoleRequest, Long userRoleId) {

        UserRole userRole = userRoleRepo.findById(userRoleId).orElse(null);
        if (userRole != null) {
            userRole.setRoleName(userRoleRequest.getRoleName());
            userRole.setRoleKey(userRoleRequest.getRoleKey());
            userRole.setDescription(userRoleRequest.getDescription());
            userRoleRepo.save(userRole);
        }
    }

    @Override
    public void removeUserRole(Long userRoleId) {

        userRoleRepo.deleteById(userRoleId);
    }
}