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
    public ResponseEntity<UserRole> getUserRoleById(@PathVariable Long userRole_id) {
        UserRole userRole = userRoleService.getUserRoleById(userRole_id);
        if (userRole != null) {
            return new ResponseEntity<>(userRole, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{userRole_id}")
    public ResponseEntity<Void> updateUserRole(@RequestBody UserRoleRequest userRoleRequest,
            @PathVariable Long userRole_id) {
        userRoleService.updateUserRole(userRoleRequest, userRole_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{userRole_id}")
    public ResponseEntity<Void> removeUserRole(@PathVariable Long userRole_id) {
        userRoleService.removeUserRole(userRole_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
