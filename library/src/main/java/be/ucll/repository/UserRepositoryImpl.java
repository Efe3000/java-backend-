package be.ucll.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import be.ucll.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
    
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate; 
    }    

    @Override
    public List<User> allUsers(){
        return jdbcTemplate.query("SELECT * FROM users",
         new UserRowMapper());  
    }

    @Override
    public List<User> usersOlderThan(int age){
        return jdbcTemplate.query("SELECT * FROM users WHERE age >= ?",
        new UserRowMapper(), age );   
    }

//     @Override
//     public List<User> usersByName(String name) {
//     String sql = "SELECT * FROM User WHERE name = ?";
//     return jdbcTemplate.query(sql, new UserRowMapper(), name);
// }
    @Override
    public List<User> usersByName(String name){
        return jdbcTemplate.query("SELECT * FROM users WHERE name = ?",
            new UserRowMapper(), name );
    }

      @Override
    public User userExists(String email) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM users WHERE email = ?", new UserRowMapper(), email);
        } catch (EmptyResultDataAccessException e) {
            return null; // Or handle appropriately
        }
    }
    // @Override
    // public User userExists(String email) {
    //     return jdbcTemplate.queryForObject("SELECT * FROM User WHERE email = ?", new UserRowMapper(), email); 
    // }

   
    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (name, password, email, age) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getEmail(), user.getAge());
    }
       
}







