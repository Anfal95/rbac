package com.RBAC.RBAC.controllers;

import com.RBAC.RBAC.RbacApplicationTests;
import com.RBAC.RBAC.domain.entities.Permission;
import com.RBAC.RBAC.domain.entities.Role;
import com.RBAC.RBAC.domain.entities.User;
import com.RBAC.RBAC.domain.enums.Roles;
import com.RBAC.RBAC.domain.repositories.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RoleControllerTest extends RbacApplicationTests {

    @SpyBean
    private RoleRepository roleRepository;

    @SpyBean
    private PermissionRepository permissionRepository;

    @SpyBean
    private UserRepository userRepository;

    private Role role = new Role();

    private User user = new User();

    private List<Permission> permissions = new ArrayList<>();

    private Permission permission = new Permission();

    @BeforeEach
    void prepareTest() {

        user.setEmail("test@example.com");
        user.setId(1L);
        user.setPhone_number("079");
        user.setName("test");

        role.setRole_en(Roles.ADMIN);
        role.setRole_ar("آدمن");
        role.setId(1L);

        permission.setName("create");
        permission.setId(1L);
        permission.setDescription("create page");
        permissions.add(permission);

        when(roleRepository.findOneById(anyLong())).thenReturn(role);
        when(userRepository.findOneById(anyLong())).thenReturn(user);
        when(permissionRepository.findOneById(anyLong())).thenReturn(permission);
    }

    @Test
    @WithMockUser(username = "admin@test.com", roles = "ADMIN")
    void assignRoleToUser() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/api/roles/assign/{userId}/{roleId}", 1L,1L))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    @WithMockUser(username = "admin@test.com", roles = "ADMIN")
    void addPermissionsToRole() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(permissions);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/roles/addPermissionToRole/{roleId}", 1L).contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
}
