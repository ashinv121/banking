package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.User;
import com.bank.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User user) {
        if (userRepository.existsById(userId)) {
            user.setId(userId);
            return userRepository.save(user);
        }
        return null; // Handle not found case
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null); // Handle not found case
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

//	@Override
//	public List<User> getAllUsers() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public List<User> getAllUsers() {
	    return userRepository.findAll();
	}

}
