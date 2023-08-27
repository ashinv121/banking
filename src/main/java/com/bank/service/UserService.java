package com.bank.service;

import java.util.List;

import com.bank.entity.User;

public interface UserService {
    User createUser(User user);
    User updateUser(Long userId, User user);
    User getUserById(Long userId);
    void deleteUser(Long userId);
    User getUserByEmail(String email);
	List<User> getAllUsers();
}