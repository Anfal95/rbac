package com.RBAC.RBAC.services;

import com.RBAC.RBAC.controllers.exceptions.NotFoundException;
import com.RBAC.RBAC.domain.entities.User;
import com.RBAC.RBAC.domain.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){

        List<User> allUsers = new ArrayList<>();

        allUsers = userRepository.findAll();

        return allUsers;
    }

    public User createUser(User user) {

        userRepository.save(user);

        return user;
    }

    public User updateUser(User updateUserRequest) {
        User user = userRepository.findById(updateUserRequest.getId()).orElseThrow(()->new NotFoundException("User not found","USER_NOT_FOUND"));;

        user.setEmail(updateUserRequest.getEmail());
        user.setName(updateUserRequest.getName());
        user.setPhone_number(updateUserRequest.getPhone_number());

        userRepository.save(user);

        return user;
    }

    public void deleteUser(Long userId) {

        System.out.println(userId);
        User user = userRepository.findOneById(userId);

        if(user == null){
            throw new NotFoundException("User not found","USER_NOT_FOUND");
        }

        userRepository.delete(user);

    }
}
