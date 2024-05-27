package be.ucll.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserTest {
    
    @Test 
    void testForUserWorks(){
        User user = new User("mary", "password123","mary@gmail.com", 22);
        assertEquals("mary", user.getName());
        assertEquals("password123", user.getPassword());
        assertEquals("mary@gmail.com", user.getEmail());
        assertEquals(22, user.getAge());  
    }


}