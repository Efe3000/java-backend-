package be.ucll.model;

import java.time.Year;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) @DiscriminatorColumn(name = "type")
public abstract class Publication {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@PositiveOrZero(message = "Available copies must be zero or more")
private int availableCopies = 0;

@NotBlank(message = "Title is required")
private String title;


@Column(insertable = false, updatable = false) 
private String type;


private int publicationYear;

protected Publication(){}
public Publication(int availableCopies, String title, int publicationYear ){
    setAvailableCopies(availableCopies);
    setTitle(title);
    setPublicationYear(publicationYear);
}

public String getTitle() {
    return title;
}

public void setTitle(String title){
    if(title.isEmpty()|| title.trim().isEmpty()){
        throw new DomainException("title cannot be empty");
    }
    this.title = title;
}

public int getPublicationYear() {
    return publicationYear;
}

public void setPublicationYear(int publicationYear) {
     if(publicationYear < 0){
            throw new DomainException("publicationYear must be a positive number");
        }
        if(publicationYear >= Year.now().getValue()){
            throw new DomainException("publication year cannot be in the future");
        }

        this.publicationYear = publicationYear;
}

public int getAvailableCopies() {
    return availableCopies;
}

public void setAvailableCopies(int availableCopies) {
    this.availableCopies = availableCopies;
}


public static void lendPublication(Publication pubs ){
    if(pubs.getAvailableCopies() == 0){
        throw new DomainException("no available copies left");
    }

    pubs.availableCopies --;
} // decrements each availaible copy when loans are lent 

public  static void returnPublication(Publication pubs){
    pubs.availableCopies ++; //increments the available copies when loans are returned 
}

    //getType method
    public String getType() {
        if (this instanceof Book) {
            return "Book";
        } else if (this instanceof Magazine) {
            return "Magazine";
        } else {
            return "Unknown"; 
        }
    }
    
    public void setType(String type) {
        this.type = type;
    }


}
