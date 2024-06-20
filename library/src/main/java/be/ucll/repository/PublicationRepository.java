package be.ucll.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import be.ucll.model.Book;
import be.ucll.model.Magazine;
import be.ucll.model.Publication;

@Repository
public class PublicationRepository {

public List<Book> books;
public List<Magazine> magazines;
public List<Publication> publications;

public PublicationRepository(){

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

}

public List<Publication> allPublications(){
    return publications;

}
























}
