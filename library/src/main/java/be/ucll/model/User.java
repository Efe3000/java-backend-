package be.ucll.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity 
@Table(name = "users") 
public class User {
 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank(message = "name may not be empty")    
private String name;

@NotBlank(message = "Password may not be empty")
@Size(min = 8, message = "Password must be at least 8 characters long")
private String password;

@NotBlank(message = "E-mail may not be empty")
@Email(message = "E-mail must be a valid email format.")
private String email;

@NotNull(message = "age may not be empty")
@Min(value = 0, message = "Age must be a positive integer between 0 and 101.")
@Max(value = 101, message = "Age must be a positive integer between 0 and 101.")
private int age;

@OneToOne
@JoinColumn(name = "profile_id")
public Profile profile;


protected User (){}

public User (Profile profile, String name, String password, String email, int age){
    
    setProfile(profile);
    setName(name);
    setPassword(password);
    setEmail(email);
    setAge(age);
    if (age < 18){
        throw new DomainException("User must be at least 18 years old to have a profile.");
    }
}

public User(String name, String password, String email, int age){
    setName(name);
    setPassword(password);
    setEmail(email);
    setAge(age);

}

public  void setName (String name){
    this.name = name; 
}

public void setPassword(String password){
    this.password = password;
}

public void setEmail(String email){
  
    if(!email.contains("@")|| !email.contains(".")){
        throw new DomainException("Email must be a valid format");
    }
    this.email = email;
}

public void setAge(int age){
    this.age = age;
}

public String getName() {
    return name;
}

public String getPassword() {
    return password;
}

public String getEmail() {
    return email;
}

public int getAge() {
    return age;
}

public Profile getProfile() {
    return profile;
}

public void setProfile(Profile profile) {
    this.profile = profile;
}




}
