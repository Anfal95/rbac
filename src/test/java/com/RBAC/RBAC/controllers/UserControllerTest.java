package com.RBAC.RBAC.controllers;

import com.RBAC.RBAC.RbacApplicationTests;
import com.RBAC.RBAC.domain.entities.User;
import com.RBAC.RBAC.domain.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest extends RbacApplicationTests {

    @SpyBean
    private UserRepository userRepository;

    private final User updateUserRequest = new User();

    private User user = new User();

    @BeforeEach
    void prepareTest() {

        user.setEmail("test@example.com");
        user.setId(1L);
        user.setPhone_number("079");
        user.setName("test");
        List<User> users= new ArrayList<>();
        users.add(user);

        updateUserRequest.setId(3L);
        updateUserRequest.setName("Admin");
        updateUserRequest.setEmail("admin@test.com");
        updateUserRequest.setPhone_number("0795372265");

        when(userRepository.findAll()).thenReturn(users);
        when(userRepository.findOneById(anyLong())).thenReturn(user);
    }

    @Test
    @WithMockUser(username = "admin@test.com", roles = "ADMIN")
    void getUsersByAdmin() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    @WithAnonymousUser
    void getUsersUnauthenticated() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
                .andExpect(status().isUnauthorized())
                .andDo(print())
                .andReturn();
    }

    @Test
    @WithMockUser(username = "admin@test.com", roles = "USER")
    void getUsersUnauthorized() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
                .andExpect(status().isForbidden())
                .andDo(print())
                .andReturn();
    }

    @Test
    @WithMockUser(username = "admin@test.com", roles = "ADMIN")
    void createUser() throws Exception {

        user.setName("test2");
        user.setEmail("test2@test.com");
        user.setPhone_number("0795443322");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/users").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    @WithMockUser(username = "admin@test.com", roles = "ADMIN")
    void updateUser() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(updateUserRequest);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/users").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    @WithMockUser(username = "admin@test.com", roles = "ADMIN")
    void deleteUser() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/users/{id}", 2L))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }




}
