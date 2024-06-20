package be.ucll.unit.repository;
import java.util.ArrayList;
import java.util.List; 
import be.ucll.model.User;
import be.ucll.repository.UserRepository;
    

public class UserRepositoryTestImpl implements UserRepository {
        public List<User> users;
        
        
        public UserRepositoryTestImpl () {
        users = new ArrayList<>(List.of(
        new User("John Doe", "john1234", "john.doe@ucll.be", 25),
        new User("Jane Toe", "jane1234", "jane.toe@ucll.be", 30),
        new User("Jack Doe", "jack1234", "jack.doe@ucll.be", 5),
        new User("Sarah Doe", "sarah1234", "sarah.doe@ucll.be", 4),
        new User("Birgit Doe", "birgit1234", "birgit.doe@ucll.be", 18) ));
        }
    
    
        public List<User> allUsers(){
            return users;
        }
    
        public List<User> usersOlderThan(int age){
            List<User> olderThan = new ArrayList<>();
    
            for (User i: allUsers()){
                if(i.getAge() >= age ){
                olderThan.add(i);
                }
    
            }
            return olderThan;
    
        }
    
        public List <User> usersByName(String name){
            // User user = allUsers().get(0);
            // if (user.getName() == name){
            //     System.out.println("user found"); 
            // }
            // else{
            //     System.out.println("no users found");
            // }
            // return user;
            List<User> userName = new ArrayList<>();
            String searchName = name.toLowerCase();  // Convert input name to lowercase for case-insensitive comparison
    
            for (User user : allUsers()) {
            String userNameLowerCase = user.getName().toLowerCase();  // Convert user's name to lowercase for case-insensitive comparison
            
            if (userNameLowerCase.equals(searchName) || userNameLowerCase.contains(searchName)) {
                userName.add(user);
            }
        }
        return userName;
    
        }
    
    
        public User userExists(String email) {
            User userByEmail = null;
            for (User i : allUsers()) {
                if (i.getEmail().equals(email)) {
                    userByEmail = i;
                    break; // Exit the loop once the user is found
                }
            }        
            return userByEmail;
        }
        public void resetUserData() { 
            users = new ArrayList<>(List.of(
                new User("John Doe", "john1234", "john.doe@ucll.be", 25),
                new User("Jane Toe", "jane1234", "jane.toe@ucll.be", 30),
                new User("Jack Doe", "jack1234", "jack.doe@ucll.be", 5),
                new User("Sarah Doe", "sarah1234", "sarah.doe@ucll.be", 4),
                new User("Birgit Doe", "birgit1234", "birgit.doe@ucll.be", 18) ));
                
        }
    
    
        // public void delete(User user){
        //     allUsers().remove(user.get());
        // }
    
    
        public void save(User user){

        }
    
    
    
    
    
    
    
    
    
    }
    



