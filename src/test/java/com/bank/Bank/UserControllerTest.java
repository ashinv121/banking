package com.bank.Bank;
import com.bank.entity.User;
import com.bank.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.bank.controller.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser_Success() {
        User user = new User("John", "Doe", "john@example.com", "1234567890", "password");
        when(userService.createUser(user)).thenReturn(user);

        ResponseEntity<String> response = userController.createUser(user);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contains("User created successfully"));
        assertTrue(response.getBody().contains("id"));
    }

    @Test
    public void testCreateUser_Failure() {
        User user = new User("John", "Doe", "john@example.com", "1234567890", "password");
        when(userService.createUser(user)).thenReturn(null);

        ResponseEntity<String> response = userController.createUser(user);

        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertTrue(response.getBody().contains("Error creating user"));
    }

    
}