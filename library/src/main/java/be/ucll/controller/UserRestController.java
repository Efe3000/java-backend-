package be.ucll.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import be.ucll.model.DomainException;
import be.ucll.model.Loan;
import be.ucll.model.User;
import be.ucll.service.LoanService;
import be.ucll.service.ServiceException;
import be.ucll.service.UserService;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("/users")
public class UserRestController {
    
    public final UserService userService;
    public final LoanService loanService;

    @Autowired
    public UserRestController(UserService userService, LoanService loanService){
        this.userService = userService;
        this.loanService = loanService;
    }
    
    //
     @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ServiceException.class)
    public Map<String, String> handleServiceException(ServiceException ex){
        Map<String, String> errors = new HashMap<>();
        errors.put("ServiceException", ex.getMessage());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DomainException.class)
    public Map<String, String> handleDomainException(DomainException ex){
        Map<String, String> errors = new HashMap<>();
        errors.put("DomainException", ex.getMessage());
        return errors;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST) 
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>(); for (FieldError error : ex.getFieldErrors()) {
    String fieldName = error.getField();
    String errorMessage = error.getDefaultMessage(); errors.put(fieldName, errorMessage);
    }
    return errors; }
  //

    @GetMapping 
    public List<User> getUsers(@RequestParam(value = "name", required = false) String name){
        if(name == null){
            return userService.getAllUsers();
        }
        else{
            return userService.findUserByName(name);
        }
    }

    @GetMapping("/adults")
    public List<User> getAdult(){
        return userService.getAllAdultUsers(18);
    }

    @GetMapping("/search/age/{min}/{max}")
    public List<User> getMinMax(@PathVariable int min, @PathVariable int max){
        return userService.findUsersByAge(min, max);

    }

    @GetMapping("/{email}/loans")
    public List<Loan> getUserLoans(@PathVariable String email, @RequestParam(value = "onlyActive", required = false) boolean onlyActive){
        return loanService.getLoansByUser(email, onlyActive);
    }

    @GetMapping("/oldest")
    public User getOldestUser(){
        return userService.oldestUser();
    }


    @PostMapping
    public User addUser(@Valid @RequestBody User user) {
    return userService.addUser(user); 
    }

    @PutMapping("/{email}")
    public User updateUser(@PathVariable String email, @Valid @RequestBody User user) {
    return userService.updateUser(email, user);

    }

    @DeleteMapping("/{email}/loans")
    public void removeUserLoan(@PathVariable String email) {
    userService.removeUserLoan(email); 
    }


    @DeleteMapping("/{email}")
    public void removeUser(@PathVariable String email) {
    userService.removeUser(email);
    }








}
