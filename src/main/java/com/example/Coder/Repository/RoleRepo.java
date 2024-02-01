package com.example.Coder.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Coder.Entity.Role;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
    
}
