package be.ucll.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import be.ucll.model.Book;
import be.ucll.model.Loan;
import be.ucll.model.Publication;
import be.ucll.model.User;
import be.ucll.repository.LoanRepository;
import be.ucll.repository.UserRepository;
import be.ucll.service.LoanService;
import be.ucll.unit.repository.UserRepositoryTestImpl;

public class LoanServiceTest {

    @Test 
    void given_emailOfUsers_thenUsersWithLoansAreReturned(){    

        LoanRepository loanRepo = new LoanRepository();
        UserRepository userRepo = new UserRepositoryTestImpl();
        LoanService loanService = new LoanService(loanRepo, userRepo);
        List <Loan> loanTest; 
        List<Publication> publications = new ArrayList<>();

        User user = new User("John Doe", "john1234", "john.doe@ucll.be", 25);
        User user2 = new User("Jane Toe", "jane1234", "jane.toe@ucll.be", 30);

        Book book = new Book(5, "Harry Poter", "JK rowlings", "1234567891023", 2022);
        Book book2 = new Book(4, "Spy Riots", "Peter Van Dawlings", "0034667891023", 2023);

        publications.add(book);
        publications.add(book2);


        LocalDate startDate = LocalDate.of(2023, 3, 2);
        LocalDate endDate  = LocalDate.of(2023, 3, 5);

        loanTest  = new ArrayList<>(List.of(
                new Loan(user, publications, startDate, endDate),
                new Loan(user2, publications, startDate, endDate)
                ));

        loanTest = loanService.getLoansByUser("john.doe@ucll.be", false);
        assertEquals(0,0);


       
    }
        






    }






