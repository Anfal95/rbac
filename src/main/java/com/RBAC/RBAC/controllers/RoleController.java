package com.RBAC.RBAC.controllers;

import com.RBAC.RBAC.domain.entities.Permission;
import com.RBAC.RBAC.domain.entities.Role;
import com.RBAC.RBAC.domain.entities.User;
import com.RBAC.RBAC.responses.BaseResponse;
import com.RBAC.RBAC.services.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/roles")
//@PreAuthorize("hasAnyRole('ADMIN')")
@Slf4j
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping("/assign/{userId}/{roleId}")
    public BaseResponse assignRole(@PathVariable Long userId,
                                   @PathVariable Long roleId){

        log.debug("Assign Role to User");

        roleService.assignUserRole(userId, roleId);

        return new BaseResponse(true, "Success");
    }

    @PostMapping("/addPermissionToRole/{roleId}")
    public BaseResponse addPermissionsToRole(@Valid @RequestBody List<Permission> permissions,
                                             @PathVariable Long roleId){

        log.debug("Add Permissions to Role");

        roleService.addPermissionsToRole(permissions, roleId);

        return new BaseResponse(true, "Success");
    }
}
