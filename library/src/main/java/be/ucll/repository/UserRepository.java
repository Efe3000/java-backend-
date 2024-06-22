package be.ucll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.ucll.model.User;

@Repository 
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    List<User> findByAgeGreaterThan(int age);
    

    List <User> findUsersByName(String name);

    User findUserByEmail(String email);
    
    User findFirstByOrderByAgeDesc();



    
}