package com.example.Coder.Service;

import java.util.List;
import com.example.Coder.Entity.UserRole;
import com.example.Coder.Request.UserRoleRequest;

public interface UserRoleService {

    void addUserRole(UserRoleRequest userRoleRequest);

    List<UserRole> getAllUserRoles();

    UserRole getUserRoleById(Long userRole_id);

    void updateUserRole(UserRoleRequest userRoleRequest, Long userRole_id);

    void removeUserRole(Long userRole_id);
}
