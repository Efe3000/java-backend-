package be.ucll.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "profile")
public class Profile {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;    

@NotBlank(message = "bio is required")
private String bio;

@NotBlank(message = "location is required")
private String location;

@NotBlank(message = "interests are required")
private String interests;



protected Profile (){}

public Profile(String bio, String location, String interests){

    setBio(bio);
    setLocation(location);
    setInterests(interests);
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getBio() {
    return bio;
}

public void setBio(String bio) {
    this.bio = bio;
}

public String getLocation() {
    return location;
}

public void setLocation(String location) {
    this.location = location;
}

public String getInterests() {
    return interests;
}

public void setInterests(String interests) {
    this.interests = interests;
}








}
