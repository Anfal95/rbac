package com.RBAC.RBAC.services;

import com.RBAC.RBAC.controllers.exceptions.NotFoundException;
import com.RBAC.RBAC.domain.entities.*;
import com.RBAC.RBAC.domain.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoleService {

    private RoleRepository roleRepository;

    private PermissionRepository permissionRepository;

    private RolesPermissionsRepository rolesPermissionsRepository;

    private UsersRolesRepository usersRolesRepository;

    private UserRepository userRepository;

    public RoleService(RoleRepository roleRepository,UserRepository userRepository, UsersRolesRepository usersRolesRepository, PermissionRepository permissionRepository, RolesPermissionsRepository rolesPermissionsRepository){
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.usersRolesRepository = usersRolesRepository;
        this.permissionRepository = permissionRepository;
        this.rolesPermissionsRepository = rolesPermissionsRepository;
    }

    public void assignUserRole(Long userId, Long roleId) {
        Role roleRequest = this.roleRepository.findOneById(roleId);

        if(roleRequest == null){
            throw new NotFoundException("Role not found", "ROLE_NOT_FOUND");
        }

        User userRequest = this.userRepository.findOneById(userId);

        if(userRequest == null){
            throw new NotFoundException("User not found", "USER_NOT_FOUND");
        }

        usersRolesRepository.save(new UsersRoles(userId,roleId));
    }

    public void addPermissionsToRole(List<Permission> permissions, Long roleId) {

        Role roleRequest = this.roleRepository.findOneById(roleId);

        if (roleRequest == null) {
            throw new NotFoundException("Role not found", "ROLE_NOT_FOUND");
        }

        for (Permission permission : permissions) {

            Permission permissionRequest = this.permissionRepository.findOneById(permission.getId());

            if (permissionRequest == null) {
                throw new NotFoundException("Permission not found", "PERMISSION_NOT_FOUND");
            }

            rolesPermissionsRepository.save(new RolesPermissions(permission.getId(), roleId));

        }

    }
}
