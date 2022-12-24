package com.RBAC.RBAC.controllers;

import com.RBAC.RBAC.domain.entities.User;
import com.RBAC.RBAC.responses.BaseResponse;
import com.RBAC.RBAC.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/users")
//@PreAuthorize("hasAnyRole('ADMIN')")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity getUsers() {

        log.debug("Get All Users");

        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody User createUserRequest) {

        log.debug("Create User");

        return ResponseEntity.ok(userService.createUser(createUserRequest));
    }

    @PutMapping
    public ResponseEntity updateUser(@Valid @RequestBody User updateUserRequest) {

        log.debug("Update User");

        return ResponseEntity.ok(userService.updateUser(updateUserRequest));
    }

    @DeleteMapping("/{userId}")
    public BaseResponse deleteUser(@PathVariable Long userId) {

        log.debug("Delete User");

        userService.deleteUser(userId);

        return new BaseResponse(true, "Success");
    }
}
