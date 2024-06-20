package be.ucll.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LoanTest {
 
@Test
    void ensureAllValuesAreCorrect(){
        User user = new User("Joana", "password","user@gmail.com", 24);
        Book book = new Book(2, "harry poter", "jk rowlings", "1234567891010", 2012 );
        Magazine mags = new Magazine (3,"lake wilder", "harry styles", "1234567891023", 2023);

        //Publication[] loanPublications = { new Book(1, "Title", "Author", "978-0-545-010", 2022) };
        LocalDate startDate = LocalDate.of(2023,3,2);
        LocalDate endDate = LocalDate.of(2023,3,2);
        List<Publication> newPubs = new ArrayList<>();
        newPubs.add(mags);
        newPubs.add(book);

        Loan newLoan = new Loan(user, newPubs, startDate, endDate);
        assertEquals("Joana", newLoan.getUser().getName());
        //assertEquals(newPubs, newLoan.getPublications());
        assertIterableEquals(newPubs, newLoan.getPublications());
        assertEquals(startDate, newLoan.getStartDate());
        assertEquals(endDate, newLoan.getEndDate());
    }
    

}
