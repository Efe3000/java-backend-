package be.ucll.model;

public class User {
private String name;
private String password;
private String email;
private int age;

public User(String name, String password, String email, int age){
    setName(name);
    setPassword(password);
    setEmail(email);
    setAge(age);

}

public  void setName (String name){
    if(name.isEmpty() || name.trim().isEmpty()){
        throw new DomainException("Name is required");
    }
    this.name = name; 
}

public void setPassword(String password){
    if(password.isEmpty() || password.length() < 8){
        throw new DomainException("Password must be at least 8 charaters long");
    }
    this.password = password;
}

public void setEmail(String email){
    if(!email.contains("@")|| !email.contains(".")){
        throw new DomainException("Email must be a valid format");
    }
    this.email = email;
}

public void setAge(int age){
    if(age < 0 && age > 101){
        throw new DomainException("Age must be a positive integer");
    }
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


}
