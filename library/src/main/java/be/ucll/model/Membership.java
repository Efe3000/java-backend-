package be.ucll.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "membership")
public class Membership {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id; 

  @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

@NotNull(message = "startdate is required")
LocalDate startDate;

@NotNull(message = "enddate is required")
LocalDate endDate;

@NotNull(message = "type is required")
String type;



protected Membership(){}

public Membership(User user, LocalDate startDate, LocalDate endDate, String type){
    setUser(user);
    setStartDate(startDate);
    setEndDate(endDate);
    setType(type);
}

public LocalDate getStartDate() {
    return startDate;
}

public void setStartDate(LocalDate startDate) {
    if( startDate.isBefore(LocalDate.now())){
        throw new DomainException("must be equal or after today");
    }
    this.startDate = startDate;
}

public LocalDate getEndDate() {
    return endDate;
}

public void setEndDate(LocalDate endDate) {
    if (startDate == null) {
        throw new DomainException("StartDate must be set before setting EndDate.");
    }
    if(endDate.isBefore(LocalDate.now()) || endDate.isBefore(getStartDate().plusYears(1)) ){
        throw new DomainException("must be in the future and 1 year after the start date");
    }
    this.endDate = endDate;
}

public String getType() {
    return type;
}

public void setType(String type) {
    if(!("GOLD".equals(type) || "SILVER".equals(type) || "BRONZE".equals(type))){
        throw new DomainException(" type must be one of the following: GOLD, SILVER, BRONZE");
    }
    this.type = type;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public User getUser() {
    return user;
}

public void setUser(User user) {
    this.user = user;
}












}
