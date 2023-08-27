package com.bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // You can add custom query methods here if needed
    // For example, finding a user by email
    User findByEmail(String email);
    List<User> findAll();

}
