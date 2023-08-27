package com.bank.Bank;

import com.bank.entity.User;
import com.bank.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BankApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserRepository() {
        User user = new User("John", "Doe", "john@example.com", "1234567890", "password");
        userRepository.save(user);

        assertNotNull(user.getId()); // Ensure the ID is generated

        User savedUser = userRepository.findById(user.getId()).orElse(null);
        assertNotNull(savedUser); // Ensure the user was saved and can be retrieved

        assertEquals("John", savedUser.getFirstname());
        assertEquals("Doe", savedUser.getLastname());
        assertEquals("john@example.com", savedUser.getEmail());
        assertEquals("1234567890", savedUser.getPhno());
        assertEquals("password", savedUser.getPassword());
    }
}
