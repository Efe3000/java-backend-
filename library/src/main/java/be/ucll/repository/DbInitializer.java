package be.ucll.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.ucll.model.Book;
import be.ucll.model.Magazine;
import be.ucll.model.Membership;
import be.ucll.model.User;
import jakarta.annotation.PostConstruct;

@Component
public class DbInitializer {

private UserRepository userRepository;
private PublicationRepository publicationRepository;
private MembershipRepository membershipRepository;
public List<User> users;
public List<LocalDate> startDates;
public List<LocalDate> endDates;
public List<Membership> memberships;


@Autowired
    public DbInitializer(UserRepository userRepository, PublicationRepository publicationRepository,MembershipRepository membershipRepository ) { 
        this.userRepository = userRepository;
        this.publicationRepository = publicationRepository;
        this.membershipRepository = membershipRepository;
    }

    @PostConstruct
    public void initialize() {
        User user = new User("John Doe", "john1234", "john.doe@ucll.be", 25);
        User user2 = new User("Jane Toe", "jane1234", "jane.toe@ucll.be", 30);
        User user3 = new User("Jack Doe", "jack1234", "jack.doe@ucll.be", 13);
        User user4 = new User("Sarah Doe", "sarah1234", "sarah.doe@ucll.be", 10);
        User user5 = new User("Birgit Doe", "birgit1234", "birgit.doe@ucll.be", 18);
    
        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);



        Book book = new Book(5, "Harry Poter", "JK rowlings", "1234567891023", 2022);
        Book book2 = new Book(4, "Spy Riots", "Peter Van Dawlings", "0034667891023", 2023);
        Book book3 = new Book(6, "Chemic Hater", "Ward Tim", "1234907890023", 2022);
        Book book4 = new Book(7, "Hilltop Boys", "Darya Thunder", "0004567891023", 2013);
        Magazine magazine = new Magazine(4, "Times Day", "Noil James", "123456789023", 2018);
        Magazine magazine2 = new Magazine(3, "New York Times", "DownTown", "123456788023", 2022);
        Magazine magazine3 = new Magazine(2, "Office Hours", "The Realators", "123000789023", 2012);

        publicationRepository.save(book);
        publicationRepository.save(book2);
        publicationRepository.save(book3);
        publicationRepository.save(book4);
        publicationRepository.save(magazine);
        publicationRepository.save(magazine2);
        publicationRepository.save(magazine3);



        users = new ArrayList<>(List.of(
        new User("John Doe", "john1234", "john.doe@ucll.be", 25),
        new User("Jane Toe", "jane1234", "jane.toe@ucll.be", 30),
        new User("Jack Doe", "jack1234", "jack.doe@ucll.be", 5),
        new User("Sarah Doe", "sarah1234", "sarah.doe@ucll.be", 4),
        new User("Birgit Doe", "birgit1234", "birgit.doe@ucll.be", 18) ));

        startDates = new ArrayList<>(List.of(
            LocalDate.of(2024, 7, 2),
            LocalDate.of(2024, 7, 2),
            LocalDate.of(2024, 7, 2),
            LocalDate.of(2024, 7, 2),
            LocalDate.of(2024, 7, 2)
        ));

        endDates = new ArrayList<>(List.of(
            LocalDate.of(2025, 7, 5),
            LocalDate.of(2025, 7, 5),
            LocalDate.of(2025, 7, 5),
            LocalDate.of(2025, 7, 5),
            LocalDate.of(2025, 7, 5)
            ));


        memberships = new ArrayList<>(List.of(
        new Membership(users.get(0),startDates.get(0), endDates.get(0),"GOLD"),
        new Membership(users.get(1),startDates.get(1), endDates.get(1),"BRONZE"),
        new Membership(users.get(2),startDates.get(2), endDates.get(2),"SILVER"),
        new Membership(users.get(3),startDates.get(3), endDates.get(3),"GOLD"),
        new Membership(users.get(4),startDates.get(4), endDates.get(4),"BRONZE")
        ));

        membershipRepository.save(memberships.get(0));
        membershipRepository.save(memberships.get(1));
        membershipRepository.save(memberships.get(2));
        membershipRepository.save(memberships.get(3));
        membershipRepository.save(memberships.get(4));
















    }
}
    
