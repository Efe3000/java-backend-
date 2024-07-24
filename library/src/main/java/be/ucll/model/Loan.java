package be.ucll.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "loan")
public class Loan{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
        name = "loan_publications",
        joinColumns = @JoinColumn(name = "loan_id"),
        inverseJoinColumns = @JoinColumn(name = "publication_id")

    )
    private List <Publication> publications; 
    
    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    private LocalDate endDate;

    protected Loan(){}

    public Loan(User user, List<Publication> publications, LocalDate startDate, LocalDate endDate){
       setUser(user);
       setPublications(publications);
       setStartDate(startDate);
       setEndDate(endDate);
       
    }

public void setStartDate(LocalDate startDate) {
    if (startDate == null) {
        throw new DomainException("start date is required");
    }//btw always implement null first to avoid null pointer exceptions  
    //.isBefore(), .isAfter(),.isEqual() 
    if (startDate.isAfter(LocalDate.now())) {
        throw new DomainException("start date cannot be in the future");
    }
    this.startDate = startDate;

}

private void setEndDate(LocalDate endDate){
    if (endDate.isBefore(startDate)){
        throw new DomainException("start date cannot be after enddate");
    }
    if(endDate.isAfter(LocalDate.now())){
        throw new DomainException("enddate cannot be in the future");

    }
    this.endDate = endDate;
}

public void setPublications(List <Publication> publications){
    for(Publication pub : publications){
        try{
            Publication.lendPublication(pub);
        } catch (DomainException e ){
            System.out.println("unable to lend publications for." + pub.getTitle());
        }

    }
    this.publications = publications;
//following the publication class, we set the loan pubs for each individual pub
}

public void returnPublications(List<Publication> pubs){
    for (Publication i : pubs){
         Publication.returnPublication(i);
    }

}

public User getUser() {
    return user;
}

public void setUser(User user) {
    this.user = user;
}

public List<Publication> getPublications() {
    return publications;
}

public LocalDate getStartDate() {
    return startDate;
}

public LocalDate getEndDate() {
    return endDate;
}

}