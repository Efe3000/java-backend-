
package be.ucll.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import be.ucll.model.User;
import be.ucll.repository.LoanRepository;
import be.ucll.repository.ProfileRepository;
import be.ucll.service.ServiceException;
import be.ucll.service.UserService;
import be.ucll.repository.UserRepository;
import be.ucll.unit.repository.ProfileRepositoryTestImpl;
import be.ucll.unit.repository.UserRepositoryTestImpl;



public class UserServiceTest {

private UserRepository userRepository;
private UserService userService;
public LoanRepository loanRepository;
public ProfileRepository profileRepository;

// public UserRepository userRepo;
public List<User> userTest;


    @BeforeEach //instead of declaring a new initialization per test we'll use this instead. 
    void setup(){
    userRepository = new UserRepositoryTestImpl();
    // userRepo = userRepository; // Initialize userRepo
    loanRepository = new LoanRepository();
    profileRepository = new ProfileRepositoryTestImpl();
    userService = new UserService(userRepository,loanRepository, profileRepository);
    }




    @Test
    void givenAllUsersCalled_thenAllUsersAreReturned(){
        List<User> users = userRepository.findAll();
        assertEquals(true, users.equals(userRepository.findAll()));

    }

    
      

       @Test 
       void given_adultUsersAreCalled_thenAdultUsersAreReturned(){
        List<User> users = userService.getAllAdultUsers(17);
        assertEquals(true, users.equals(userRepository.findByAgeGreaterThan(17)));

     
       }

       @Test 
       void given_allUsersMinMaxAreCalled_thenUsersMinMaxIsReturned(){
        UserRepositoryTestImpl userRepository = new UserRepositoryTestImpl();
        UserService userService = new UserService(userRepository,  loanRepository, profileRepository); 
        userTest = new ArrayList<>();

       userTest.add(new User("John Doe", "john1234", "john.doe@ucll.be", 25));
       userTest.add(new User("Jane Toe", "jane1234", "jane.toe@ucll.be", 30));
       userTest.add(new User("Birgit Doe", "birgit1234", "birgit.doe@ucll.be", 18));


       userTest = userService.findUsersByAge(18,50);
       assertNotNull(userTest);
       assertEquals(25, userTest.get(0).getAge());
       assertEquals(30, userTest.get(1).getAge());
       assertEquals(18, userTest.get(2).getAge());

       }
       @Test
       public void givenInvalidMinOrMaxAge_whenGettingAgeRangeInUserService_ThrowServiceException() {
           Exception ex = assertThrows(
                   ServiceException.class,
                   () -> userService.findUsersByAge(50,30)
           );
       }

       @Test
       void get_usersByName(){

       userService.findUserByName("john");
       assertEquals("John Doe", userRepository.findAll().get(0).getName());
       }

       @Test 
       void postUsersByEmail(){
        //write tests for when user already exists 
        //write tests for when user does not exists
            User user =  new User("Kylie Doe", "kylie1234", "kylie.doe@ucll.be", 25);
            userService.addUser(user);
    
            assertEquals(user, userRepository.findUserByEmail(user.getEmail()));
       }

       @Test 
       void putUsersByEmail(){
        //write tests for when user does not  exists 
        //write tests for when email wants to be changed 
        User user = userRepository.findAll().get(0);//John Doe, age 25
        user.setAge(26);
        user.setName("John Snow");
        userService.updateUser(user.getEmail(), user);

        assertEquals(true, userRepository.findAll().get(0).getName().equals(user.getName()));
        assertEquals(true, userRepository.findAll().get(0).getAge() == user.getAge());
       }

       @Test
       public void givenUserDoesNotExist_whenUpdatingUserInUserService_ThrowServiceException() {
           Exception ex = assertThrows(
                   ServiceException.class,
                   () -> userService.updateUser("nonexistant@email.com", userRepository.findAll().get(1))
           );
   
           assertEquals("User does not exist.", ex.getMessage());
       }

       @Test 
       void deleteUserLoan(){
        //write tests that test the size of user loans == 0 after its been deleted
        Exception ex = assertThrows(
            ServiceException.class,
            () -> userService.removeUserLoan("john.doe@ucll.be")
        );

        assertEquals("User has no active loans", ex.getMessage());
       }

       @Test 
       void deleteUser(){
        //write tests that test the size of users reduced after its been deleted
        //also varify that after deletion when the user is called it doesnt appear 
        userService.removeUser("john.doe@ucll.be");
        assertEquals(null, userRepository.findUserByEmail("john.doe@ucll.be"));

       }



}





