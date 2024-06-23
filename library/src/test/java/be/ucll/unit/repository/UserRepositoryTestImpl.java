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

import be.ucll.model.User;
import be.ucll.repository.UserRepository;
    

public class UserRepositoryTestImpl implements UserRepository {
        public List<User> users;
        
        
        public UserRepositoryTestImpl () {
        users = new ArrayList<>(List.of(
        new User("John Doe", "john1234", "john.doe@ucll.be", 25),
        new User("Jane Toe", "jane1234", "jane.toe@ucll.be", 30),
        new User("Jack Doe", "jack1234", "jack.doe@ucll.be", 5),
        new User("Sarah Doe", "sarah1234", "sarah.doe@ucll.be", 4),
        new User("Birgit Doe", "birgit1234", "birgit.doe@ucll.be", 18) ));
        }
    
       
    

    @Override
    public List<User> findAll() {
    return users; }

    
        public List<User> findByAgeGreaterThan(int age){
            List<User> olderThan = new ArrayList<>();
    
            for (User i: findAll()){
                if(i.getAge() > age ){
                olderThan.add(i);
                }
    
            }
            return olderThan;
    
        }
    
        public List <User> findUsersByName(String name){
            // User user = allUsers().get(0);
            // if (user.getName() == name){
            //     System.out.println("user found"); 
            // }
            // else{
            //     System.out.println("no users found");
            // }
            // return user;
            List<User> userName = new ArrayList<>();
            String searchName = name.toLowerCase();  // Convert input name to lowercase for case-insensitive comparison
    
            for (User user : findAll()) {
            String userNameLowerCase = user.getName().toLowerCase();  // Convert user's name to lowercase for case-insensitive comparison
            
            if (userNameLowerCase.equals(searchName) || userNameLowerCase.contains(searchName)) {
                userName.add(user);
            }
        }
        return userName;
    
        }
    
    
        public User findUserByEmail(String email) {
            User userByEmail = null;
            for (User i : findAll()) {
                if (i.getEmail().equals(email)) {
                    userByEmail = i;
                    break; // Exit the loop once the user is found
                }
            }        
            return userByEmail;
        }
        public void resetUserData() { 
            users = new ArrayList<>(List.of(
                new User("John Doe", "john1234", "john.doe@ucll.be", 25),
                new User("Jane Toe", "jane1234", "jane.toe@ucll.be", 30),
                new User("Jack Doe", "jack1234", "jack.doe@ucll.be", 5),
                new User("Sarah Doe", "sarah1234", "sarah.doe@ucll.be", 4),
                new User("Birgit Doe", "birgit1234", "birgit.doe@ucll.be", 18) ));
                
        }


        @Override
        public void flush() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'flush'");
        }


        @Override
        public <S extends User> S saveAndFlush(S entity) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
        }


        @Override
        public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
        }


        @Override
        public void deleteAllInBatch(Iterable<User> entities) {
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
        public User getOne(Long id) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getOne'");
        }


        @Override
        public User getById(Long id) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getById'");
        }


        @Override
        public User getReferenceById(Long id) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
        }


        @Override
        public <S extends User> List<S> findAll(Example<S> example) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        }


        @Override
        public <S extends User> List<S> saveAll(Iterable<S> entities) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
        }


        @Override
        public List<User> findAllById(Iterable<Long> ids) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
        }


        @Override
        public <S extends User> S save(S entity) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'save'");
        }


        @Override
        public Optional<User> findById(Long id) {
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
        public void delete(User entity) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'delete'");
        }


        @Override
        public void deleteAllById(Iterable<? extends Long> ids) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
        }


        @Override
        public void deleteAll(Iterable<? extends User> entities) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
        }


        @Override
        public void deleteAll() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
        }


        @Override
        public List<User> findAll(Sort sort) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        }


        @Override
        public Page<User> findAll(Pageable pageable) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        }


        @Override
        public <S extends User> Optional<S> findOne(Example<S> example) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findOne'");
        }


        @Override
        public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        }


        @Override
        public <S extends User> long count(Example<S> example) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'count'");
        }


        @Override
        public <S extends User> boolean exists(Example<S> example) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'exists'");
        }


        @Override
        public <S extends User, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findBy'");
        }


      

        @Override
        public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        }

        @Override
        public User findFirstByOrderByAgeDesc() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findFirstByOrderByAgeDesc'");
        }

    
    
    
    
    
    
    
    
    
    
    
    }
    



