package be.ucll.model;

import jakarta.validation.constraints.NotBlank;

public class Book extends Publication {
   
    @NotBlank(message = "Author is required")
    private String author;
    
    @NotBlank(message = "ISBN is required")
    private String isbn;

    public Book(int availableCopies, String title, String author, String isbn, int publicationYear){
        super(availableCopies, title, publicationYear);
        setAuthor(author);
        setIsbn(isbn);

    }

 

    public void setAuthor(String author) {
        if(author.isEmpty() || author.trim().isEmpty()){
            throw new DomainException("author cannot be empty");
        }
        this.author = author;
    }

    public void setIsbn(String isbn) {
        if(isbn.isEmpty() || isbn.trim().isEmpty() || isbn.length() != 13){
            throw new DomainException("isbn cannot be empty");
        }
        this.isbn = isbn;
    }


   

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }












}
