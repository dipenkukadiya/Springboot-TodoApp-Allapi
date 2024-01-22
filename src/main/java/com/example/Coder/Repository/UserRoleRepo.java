package com.example.Coder.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Coder.Entity.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole, Long> {

}
