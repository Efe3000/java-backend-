package be.ucll.service;

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
        return loanRepository.allLoans();
    }



    public List<Loan> getLoansByUser(String email, boolean onlyActive) {
        User existingUser = userRepository.findUserByEmail(email);
      
        //check if user even exists 
        if (existingUser == null) {
         throw new ServiceException("User does not exist.");
         }
 
         return loanRepository.findLoansByUser(email, false);
 
    }








}
