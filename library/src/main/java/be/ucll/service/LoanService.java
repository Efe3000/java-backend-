package be.ucll.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.ucll.model.Loan;
import be.ucll.model.User;
import be.ucll.repository.LoanRepository;
import be.ucll.repository.UserRepository;

@Service
public class LoanService {
    public final LoanRepository loanRepository;
    public final UserRepository userRepository;

    @Autowired 
    public LoanService(LoanRepository loanRepository, UserRepository userRepository){
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
    }

    public List<Loan> getAllLoans(){
        return loanRepository.findAll();
    }
    public List<Loan> getLoansByUser(String email, boolean onlyActive) {
        User user = userRepository.findUserByEmail(email);
        
        if (userRepository.findUserByEmail(email) == null){
            throw new ServiceException("user does not exists");
        }
        return loanRepository.findByUser(user);
    }

    
    public void returnLoan(LocalDate returnDate){
    
    //to be continued 

    }








}
