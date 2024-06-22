// package be.ucll.repository;

// import java.util.List;
// import java.util.Optional;
// import java.util.function.Function;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.dao.EmptyResultDataAccessException;
// import org.springframework.data.domain.Example;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;
// import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.stereotype.Repository;

// import be.ucll.model.User;

// public class UserRepositoryImpl implements UserRepository {
    
//     private JdbcTemplate jdbcTemplate;
    
//     @Autowired
//     public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
//         this.jdbcTemplate = jdbcTemplate; 
//     }    

//     @Override
//     public List<User> allUsers(){
//         return jdbcTemplate.query("SELECT * FROM users",
//          new UserRowMapper());  
//     }

//     @Override
//     public List<User> usersOlderThan(int age){
//         return jdbcTemplate.query("SELECT * FROM users WHERE age >= ?",
//         new UserRowMapper(), age );   
//     }

// //     @Override
// //     public List<User> usersByName(String name) {
// //     String sql = "SELECT * FROM User WHERE name = ?";
// //     return jdbcTemplate.query(sql, new UserRowMapper(), name);
// // }
//     @Override
//     public List<User> usersByName(String name){
//         return jdbcTemplate.query("SELECT * FROM users WHERE name = ?",
//             new UserRowMapper(), name );
//     }

//       @Override
//     public User userExists(String email) {
//         try {
//             return jdbcTemplate.queryForObject("SELECT * FROM users WHERE email = ?", new UserRowMapper(), email);
//         } catch (EmptyResultDataAccessException e) {
//             return null; // Or handle appropriately
//         }
//     }
//     // @Override
//     // public User userExists(String email) {
//     //     return jdbcTemplate.queryForObject("SELECT * FROM User WHERE email = ?", new UserRowMapper(), email); 
//     // }

   
//     @Override
//     public <S> S save(User user) {
//         String sql = "INSERT INTO users (name, password, email, age) VALUES (?, ?, ?, ?)";
//         jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getEmail(), user.getAge());
//         return null;
//     }

//     @Override
//     public void deleteAllByIdInBatch(Iterable<Long> ids) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'deleteAllByIdInBatch'");
//     }

//     @Override
//     public void deleteAllInBatch() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
//     }

//     @Override
//     public void deleteAllInBatch(Iterable<User> entities) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
//     }

//     @Override
//     public <S extends User> List<S> findAll(Example<S> example) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findAll'");
//     }

//     @Override
//     public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findAll'");
//     }

//     @Override
//     public void flush() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'flush'");
//     }

//     @Override
//     public User getById(Long arg0) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'getById'");
//     }

//     @Override
//     public User getOne(Long arg0) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'getOne'");
//     }

//     @Override
//     public User getReferenceById(Long id) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
//     }

//     @Override
//     public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
//     }

//     @Override
//     public <S extends User> S saveAndFlush(S entity) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
//     }

//     @Override
//     public List<User> findAll() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findAll'");
//     }

//     @Override
//     public List<User> findAllById(Iterable<Long> ids) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
//     }

//     @Override
//     public <S extends User> List<S> saveAll(Iterable<S> entities) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
//     }

//     @Override
//     public long count() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'count'");
//     }

//     @Override
//     public void delete(User entity) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'delete'");
//     }

//     @Override
//     public void deleteAll() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
//     }

//     @Override
//     public void deleteAll(Iterable<? extends User> entities) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
//     }

//     @Override
//     public void deleteAllById(Iterable<? extends Long> ids) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
//     }

//     @Override
//     public void deleteById(Long id) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
//     }

//     @Override
//     public boolean existsById(Long id) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'existsById'");
//     }

//     @Override
//     public Optional<User> findById(Long id) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findById'");
//     }

//     @Override
//     public <S extends User> S save(S entity) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'save'");
//     }

//     @Override
//     public List<User> findAll(Sort sort) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findAll'");
//     }

//     @Override
//     public Page<User> findAll(Pageable pageable) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findAll'");
//     }

//     @Override
//     public <S extends User> long count(Example<S> example) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'count'");
//     }

//     @Override
//     public <S extends User> boolean exists(Example<S> example) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'exists'");
//     }

//     @Override
//     public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findAll'");
//     }

//     @Override
//     public <S extends User, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findBy'");
//     }

//     @Override
//     public <S extends User> Optional<S> findOne(Example<S> example) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findOne'");
//     }
       
// }







