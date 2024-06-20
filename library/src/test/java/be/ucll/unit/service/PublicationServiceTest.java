package be.ucll.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import be.ucll.model.Book;
import be.ucll.model.Publication;
import be.ucll.repository.PublicationRepository;
import be.ucll.service.PublicationService;

public class PublicationServiceTest {


@Test 
void given_filterUsersByTitleAndType_thenFilteredUsersAreReturned(){
    PublicationRepository publicationRepository = new PublicationRepository();
    PublicationService publicationService = new PublicationService(publicationRepository);


    List<Publication> pubTest = new ArrayList<>();
    pubTest.add(new Book(5, "Harry Poter", "JK rowlings", "1234567891023", 2022));

    pubTest = publicationService.findPublicationsByTitleAndType("h", "Book");

    assertNotNull(pubTest);
    assertEquals("Harry Poter", pubTest.get(0).getTitle());

}

@Test 
void given_anIntForAvailableCopies_thenAllAvailableCopiesAreReturned(){
    PublicationRepository publicationRepository = new PublicationRepository();
    PublicationService publicationService = new PublicationService(publicationRepository);


    List<Publication> pubTest = new ArrayList<>();
    pubTest.add (new Book(6, "Chemic Hater", "Ward Tim", "1234907890023", 2022));
    pubTest.add (new Book(7, "Hilltop Boys", "Darya Thunder", "0004567891023", 2013));

    pubTest = publicationService.returnAvailableCopies(6);

    assertNotNull(pubTest);
    assertTrue(pubTest.size() == 2); 
    assertEquals("Chemic Hater", pubTest.get(0).getTitle());
    assertEquals("Hilltop Boys", pubTest.get(1).getTitle()); 

}







}
