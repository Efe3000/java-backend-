package be.ucll.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import be.ucll.model.Book;
import be.ucll.model.Loan;
import be.ucll.model.Magazine;
import be.ucll.model.Publication;
import be.ucll.model.User;

@Repository
public class LoanRepository {
    
    public List<Book> books;
    public List<Magazine> magazines;
    
    public List<Publication> publications;
    public List<User> users;
    public List<Loan> loans;


    public LoanRepository(){

            //publication repo     

            books = new ArrayList<>(List.of( 
            new Book(5, "Harry Poter", "JK rowlings", "1234567891023", 2022),
            new Book(4, "Spy Riots", "Peter Van Dawlings", "0034667891023", 2023),
            new Book(6, "Chemic Hater", "Ward Tim", "1234907890023", 2022),
            new Book(7, "Hilltop Boys", "Darya Thunder", "0004567891023", 2013)
            ));

            magazines = new ArrayList<>(List.of(
                new Magazine(4, "Times Day", "Noil James", "123456789023", 2018),
                new Magazine(3, "New York Times", "DownTown", "123456788023", 2022),
            new Magazine(2, "Office Hours", "The Realators", "123000789023", 2012)
            ));

            publications = new ArrayList<>();
            publications.addAll(books);
            publications.addAll(magazines);

        //user repo 
        users = new ArrayList<>(List.of(
            new User("John Doe", "john1234", "john.doe@ucll.be", 25),
            new User("Jane Toe", "jane1234", "jane.toe@ucll.be", 30),
            new User("Jack Doe", "jack1234", "jack.doe@ucll.be", 5),
            new User("Sarah Doe", "sarah1234", "sarah.doe@ucll.be", 4),
            new User("Birgit Doe", "birgit1234", "birgit.doe@ucll.be", 18) ));
            

            List<LocalDate> startDates = new ArrayList<>();
            List<LocalDate> endDates = new ArrayList<>();

            // Adding start dates
            startDates.add(LocalDate.of(2023, 3, 2));
            startDates.add(LocalDate.of(2023, 3, 3));
            startDates.add(LocalDate.of(2023, 3, 4));
            startDates.add(LocalDate.of(2023, 3, 5));
            startDates.add(LocalDate.of(2023, 3, 6));

                
            // Adding end dates (assuming corresponding indexes in startDates and endDates match)
            endDates.add(LocalDate.of(2023, 3, 5));
            endDates.add(LocalDate.of(2023, 3, 6));
            endDates.add(LocalDate.of(2023, 3, 7));
            endDates.add(LocalDate.of(2023, 3, 8));
            endDates.add(LocalDate.of(2023, 3, 9));

        //loan repo 
        loans  = new ArrayList<>(List.of(
                new Loan(users.get(0), publications, startDates.get(0), endDates.get(0)),
                new Loan(users.get(1), publications, startDates.get(1), endDates.get(1)), 
                new Loan(users.get(2), publications, startDates.get(2), endDates.get(2)), 
                new Loan(users.get(3), publications, startDates.get(3), endDates.get(3)), 
                new Loan(users.get(4), publications, startDates.get(4), endDates.get(4))
            ));
            
    }

    public List<Loan> allLoans(){
        return loans;
    }


    public List<Loan> findLoansByUser(String email, boolean onlyActive){
        List<Loan> loanList = new ArrayList<>();
        
        for(Loan l: allLoans()){
            String lowerL = l.getUser().getEmail().toLowerCase();
            if(lowerL.contains(email) || lowerL.equals(lowerL) ){
                if(onlyActive){
                    if(l.getEndDate() == null){
                        loanList.add(l);

                    }
                }
               
            }
    
        }

        return loanList;
    }





}
