package be.ucll.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


public class BookTest {


@Test 
void testAllWorks(){
    Book book = new Book(0, "Harry poter", "jk rowlings", "1234567890000",2022);
    assertEquals("Harry poter", book.getTitle());
    assertEquals("jk rowlings", book.getAuthor());
    assertEquals("1234567890000", book.getIsbn());
    assertEquals(2022, book.getPublicationYear());

}


@Test
    public void testEmptyTitle() {
        // Test when title is empty
        assertThrows(DomainException.class, () -> { new Book(0, "", "jk rowlings", "1234567890000", 2022); });
    }


    @Test
    public void givenAnEmptyAuthor_whenCalled_ThenAnErrorIsCalled() {
        // Test when author is empty
        assertThrows(DomainException.class, () -> { new Book(0, "Harry poter", "", "1234567890000", 2022); });
    }

    

    @Test
    public void givenAninvalidIsbn_whenCalled_ThenAnErrorIsCalled() {
        // Test when author is empty
        assertThrows(DomainException.class, () -> { new Book(0, "Harry poter", "jk rowlings", "123", 2022); });
        assertThrows(DomainException.class, () -> { new Book(0, "Harry poter", "jk rowlings", "", 2022); });

    }

    @Test
    public void givenAninvalidPublicationYear_whenCalled_ThenAnErrorIsCalled() {
        // Test when author is empty
        assertThrows(DomainException.class, () -> { new Book(0, "Harry poter", "jk rowlings", "1234567890000", -100); });

    }




    
}
