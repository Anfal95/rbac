package com.RBAC.RBAC.controllers;

import com.RBAC.RBAC.domain.entities.Permission;
import com.RBAC.RBAC.services.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/permissions")
//@PreAuthorize("hasAnyRole('ADMIN')")
@Slf4j
public class PermissionController {

}
