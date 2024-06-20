package be.ucll.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.ucll.model.Loan;
import be.ucll.model.User;
import be.ucll.repository.LoanRepository;
import be.ucll.repository.UserRepository;

@Service
public class UserService {
    
private final UserRepository userRepository;
private final LoanRepository loanRepository;


    @Autowired 
    public UserService(UserRepository userRepository,  LoanRepository loanRepository ){
        this.userRepository = userRepository;
        this.loanRepository = loanRepository;
    }


    public List<User> getAllUsers(){
        return userRepository.allUsers();
    }

    public List<User> getAllAdultUsers(int age){
       
        if(age < 18){
            throw new ServiceException("error");
        }
        return userRepository.usersOlderThan(18);

    }


    public List<User> findUsersByAge(int min, int max){
        List<User> minMax = new ArrayList<>();
        
            if(min < 0 || max > 150){
                throw new ServiceException("Invalid age range. Age must be between 0 and 150.");
            }
            if (min > max ){
                throw new ServiceException("Minimum age cannot be greater than maximum age.");
            }
        
            for(User i: userRepository.allUsers()){
                if(i.getAge() >= min && i.getAge() <= max){
                    minMax.add(i);
                }
                else if(minMax.isEmpty()){
                    new ArrayList<>();
               }
                
            }

        return minMax;


    }

    public List<User> findUserByName(String name){
            if( userRepository.usersByName(name) == null ){
                throw new ServiceException("no users with given name");
            }
        
        return userRepository.usersByName(name);
    }

    public User addUser(User user){
        User existingUser = userRepository.userExists(user.getEmail());
            if(existingUser != null){
                throw new ServiceException("user already exists");
            }

    //     String userEmail = user.getEmail();

    //    for(User i: userRepository.allUsers()){
    //     if(i.getEmail().equals(userEmail)){
    //         throw new ServiceException("user already exists");
    //     }
    //    }
       userRepository.allUsers().add(user);
       return user;

    }
    
    public User updateUser(String email, User newUser){
        User existingUser = userRepository.userExists(email);
       
        //check if user even exists 
        if (existingUser == null) {
         throw new ServiceException("User does not exist.");
         }
         //if the email tries to be changed from the request param body 
         if (!email.equals(newUser.getEmail())) {
            throw new ServiceException("Email cannot be changed.");
         }
 
         //update existing user to new user 
         existingUser.setName(newUser.getName()); 
         existingUser.setAge(newUser.getAge());
         existingUser.setPassword(newUser.getPassword());
         
 
        
         userRepository.allUsers().add(existingUser);  
         return existingUser;
        }


    public  void removeUserLoan (String email){
        User user = userRepository.userExists(email);
        
        if(user == null){
            throw new ServiceException("User does not exist");
        }

        List<Loan> userLoan = loanRepository.findLoansByUser(email, false);

        if(userLoan.isEmpty()) {
            throw new ServiceException("User has no active loans");
        } 
        else if(!userLoan.isEmpty()) {
            throw new ServiceException("User has active loans");
        } 
        else{
            userLoan.removeAll(userLoan);
            System.out.println("Loan of user successfully deleted.");
        }

    }


    //Q16 
    public  void removeUser (String email){
        User user = userRepository.userExists(email);

        
        if(user == null){
            throw new ServiceException("User does not exists");
        }

        List<Loan> userLoan = loanRepository.findLoansByUser(user.getEmail(), false);

        // if(userLoan.isEmpty()) {
        //     throw new ServiceException("User has no active loans");
        // } 
        if(!userLoan.isEmpty()) {
            throw new ServiceException("User has active loans");
        } 

        //delete specified user 
        userRepository.allUsers().remove(user);

        System.out.println("User successfully deleted.");
    }








}
