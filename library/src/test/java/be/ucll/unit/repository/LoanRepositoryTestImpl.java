package be.ucll.unit.repository;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import be.ucll.model.Book;
import be.ucll.model.Loan;
import be.ucll.model.Magazine;
import be.ucll.model.Publication;
import be.ucll.model.User;
import be.ucll.repository.LoanRepository;


public class LoanRepositoryTestImpl  implements LoanRepository{
        
        public List<Book> books;
        public List<Magazine> magazines;
        
        public List<Publication> publications;
        public List<User> users;
        public List<Loan> loans;
    
    
        public LoanRepositoryTestImpl (){
    
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

        @Override
        public void flush() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'flush'");
        }

        @Override
        public <S extends Loan> S saveAndFlush(S entity) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
        }

        @Override
        public <S extends Loan> List<S> saveAllAndFlush(Iterable<S> entities) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
        }

        @Override
        public void deleteAllInBatch(Iterable<Loan> entities) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> ids) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'deleteAllByIdInBatch'");
        }

        @Override
        public void deleteAllInBatch() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
        }

        @Override
        public Loan getOne(Long id) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getOne'");
        }

        @Override
        public Loan getById(Long id) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getById'");
        }

        @Override
        public Loan getReferenceById(Long id) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
        }

        @Override
        public <S extends Loan> List<S> findAll(Example<S> example) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        }

        @Override
        public <S extends Loan> List<S> findAll(Example<S> example, Sort sort) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        }

        @Override
        public <S extends Loan> List<S> saveAll(Iterable<S> entities) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
        }

        @Override
        public List<Loan> findAll() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        }

        @Override
        public List<Loan> findAllById(Iterable<Long> ids) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
        }

        @Override
        public <S extends Loan> S save(S entity) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'save'");
        }

        @Override
        public Optional<Loan> findById(Long id) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findById'");
        }

        @Override
        public boolean existsById(Long id) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'existsById'");
        }

        @Override
        public long count() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'count'");
        }

        @Override
        public void deleteById(Long id) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
        }

        @Override
        public void delete(Loan entity) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'delete'");
        }

        @Override
        public void deleteAllById(Iterable<? extends Long> ids) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
        }

        @Override
        public void deleteAll(Iterable<? extends Loan> entities) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
        }

        @Override
        public void deleteAll() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
        }

        @Override
        public List<Loan> findAll(Sort sort) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        }

        @Override
        public Page<Loan> findAll(Pageable pageable) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        }

        @Override
        public <S extends Loan> Optional<S> findOne(Example<S> example) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findOne'");
        }

        @Override
        public <S extends Loan> Page<S> findAll(Example<S> example, Pageable pageable) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        }

        @Override
        public <S extends Loan> long count(Example<S> example) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'count'");
        }

        @Override
        public <S extends Loan> boolean exists(Example<S> example) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'exists'");
        }

        @Override
        public <S extends Loan, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findBy'");
        }

        @Override
        public List<Loan> findByUser(User user) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findByUser'");
        }



       
    
    
    
    
    }
    
