package be.ucll.repository;

import java.util.List;

import be.ucll.model.User;

public interface UserRepository {

    List<User> allUsers();

    List<User> usersOlderThan(int age);
    

    List <User> usersByName(String name);

    User userExists(String email);

    void save(User user);

    
}