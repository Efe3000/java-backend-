package be.ucll.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.ucll.model.Loan;
import be.ucll.model.User;


@Repository
public interface LoanRepository  extends JpaRepository<Loan, Long>{

    List<Loan> findAll();
    List<Loan> findByUser(User user);

    
}