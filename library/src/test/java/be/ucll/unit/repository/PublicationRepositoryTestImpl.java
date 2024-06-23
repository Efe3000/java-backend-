package be.ucll.unit.repository;
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
import be.ucll.model.Magazine;
import be.ucll.model.Publication;
import be.ucll.repository.PublicationRepository;


public class PublicationRepositoryTestImpl implements PublicationRepository {



public List<Book> books;
public List<Magazine> magazines;
public List<Publication> publications;

public PublicationRepositoryTestImpl(){

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
@Override
public List<Publication> findAll(){
    return publications;

}

@Override
public void flush() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'flush'");
}

@Override
public <S extends Publication> S saveAndFlush(S entity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
}

@Override
public <S extends Publication> List<S> saveAllAndFlush(Iterable<S> entities) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
}

@Override
public void deleteAllInBatch(Iterable<Publication> entities) {
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
public Publication getOne(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getOne'");
}

@Override
public Publication getById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getById'");
}

@Override
public Publication getReferenceById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
}

@Override
public <S extends Publication> List<S> saveAll(Iterable<S> entities) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
}

@Override
public List<Publication> findAllById(Iterable<Long> ids) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
}

@Override
public <S extends Publication> S save(S entity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'save'");
}

@Override
public Optional<Publication> findById(Long id) {
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
public void delete(Publication entity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
}

@Override
public void deleteAllById(Iterable<? extends Long> ids) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
}

@Override
public void deleteAll(Iterable<? extends Publication> entities) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
}

@Override
public void deleteAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
}


@Override
public <S extends Publication> Optional<S> findOne(Example<S> example) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findOne'");
}



@Override
public <S extends Publication> long count(Example<S> example) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'count'");
}

@Override
public <S extends Publication> boolean exists(Example<S> example) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'exists'");
}

@Override
public <S extends Publication, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findBy'");
}



@Override
public List<Publication> findByType(String type) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findByType'");
}

@Override
public List<Publication> findByTitleContainsIgnoreCase(String title) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findByTitleContainsIgnoreCase'");
}

@Override
public List<Publication> findByTypeAndTitleContainsIgnoreCase(String type, String title) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findByTypeAndTitleContainsIgnoreCase'");
}

@Override
public List<Publication> findByAvailableCopies(int availableCopies) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findByAvailableCopies'");
}
@Override
public <S extends Publication> List<S> findAll(Example<S> example) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
}
@Override
public <S extends Publication> List<S> findAll(Example<S> example, Sort sort) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
}
@Override
public List<Publication> findAll(Sort sort) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
}
@Override
public Page<Publication> findAll(Pageable pageable) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
}
@Override
public <S extends Publication> Page<S> findAll(Example<S> example, Pageable pageable) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
}


























}


