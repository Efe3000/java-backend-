package be.ucll.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.ucll.model.User;
import jakarta.annotation.PostConstruct;

@Component
public class DbInitializer {

private UserRepository userRepository;

@Autowired
    public DbInitializer(UserRepository userRepository) { 
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void initialize() {
        User user = new User("John Doe", "john1234", "john.doe@ucll.be", 25);
        User user2 = new User("Jane Toe", "jane1234", "jane.toe@ucll.be", 30);
        User user3 = new User("Jack Doe", "jack1234", "jack.doe@ucll.be", 13);
        User user4 = new User("Sarah Doe", "sarah1234", "sarah.doe@ucll.be", 10);
        User user5 = new User("Birgit Doe", "birgit1234", "birgit.doe@ucll.be", 18);
    
        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);

    }
}
    
