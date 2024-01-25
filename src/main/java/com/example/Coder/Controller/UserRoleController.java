package com.example.Coder.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Coder.Entity.UserRole;
import com.example.Coder.Request.UserRoleRequest;
import com.example.Coder.Service.UserRoleService;

@RestController
@RequestMapping("/api/v1/user-roles")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping
    public ResponseEntity<Void> addUserRole(@RequestBody UserRoleRequest userRoleRequest) {
        userRoleService.addUserRole(userRoleRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserRole>> getAllUserRoles() {
        List<UserRole> userRoles = userRoleService.getAllUserRoles();
        return new ResponseEntity<>(userRoles, HttpStatus.OK);
    }

    @GetMapping("/{userRole_id}")
    public ResponseEntity<UserRole> getUserRoleById(@PathVariable Long userRoleId) {
        UserRole userRole = userRoleService.getUserRoleById(userRoleId);
        if (userRole != null) {
            return new ResponseEntity<>(userRole, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{userRoleId}")
    public ResponseEntity<Void> updateUserRole(@RequestBody UserRoleRequest userRoleRequest,
            @PathVariable Long userRoleId) {
        userRoleService.updateUserRole(userRoleRequest, userRoleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{userRoleId}")
    public ResponseEntity<Void> removeUserRole(@PathVariable Long userRoleId) {
        userRoleService.removeUserRole(userRoleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
