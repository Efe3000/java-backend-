DROP TABLE IF EXISTS profile;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS publication;
DROP TABLE IF EXISTS memberships;
DROP TABLE IF EXISTS loan_publications;
DROP TABLE IF EXISTS loan;




CREATE TABLE profile(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    bio VARCHAR(255),
    location VARCHAR(255),
    interests VARCHAR(255)
);


CREATE TABLE users(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    age INT,
    profile_id BIGINT,
    FOREIGN KEY(profile_id) REFERENCES profile
);

CREATE TABLE publication(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR (255),
    available_copies INT,
    title VARCHAR(255),
    publication_year INT,
    author VARCHAR(255),
    isbn VARCHAR (13),
    editor VARCHAR(255),
    issn VARCHAR(255)

);

CREATE TABLE membership(
    id LONG AUTO_INCREMENT PRIMARY KEY,
    start_date Date,
    end_date Date,
    type VARCHAR(255),
    number_of_free_loans INT,
    user_id BIGINT,
    FOREIGN KEY(user_id) REFERENCES users

);
CREATE TABLE loan ( 
id BIGINT AUTO_INCREMENT PRIMARY KEY,
user_id BIGINT,
publication_id BIGINT,
start_date DATE,
end_date DATE,
FOREIGN KEY(user_id) REFERENCES users,
FOREIGN KEY(publication_id) REFERENCES profile

);


CREATE TABLE loan_publications ( 
loan_id BIGINT,
publication_id BIGINT,
PRIMARY KEY (loan_id, publication_id),
FOREIGN KEY (loan_id) REFERENCES loan(id),
FOREIGN KEY (publication_id) REFERENCES publication(id)
);










