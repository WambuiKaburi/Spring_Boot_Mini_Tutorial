package com.interntesting.demo.Services;

import com.interntesting.demo.Models.User;

import java.util.List;

public interface UserService {
    void addUser(User u);

    User updateUser(User u, Long id);

    User findById(Long id);

    List<User> findAll();

    void deleteUser(Long id);
}
