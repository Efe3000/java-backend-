DROP TABLE IF EXISTS profile;
DROP TABLE IF EXISTS users;


CREATE TABLE profile(
    id LONG AUTO_INCREMENT PRIMARY KEY,
    bio VARCHAR(255),
    location VARCHAR(255),
    interests VARCHAR(255)
);


CREATE TABLE users(
    id LONG AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    age INT,
    profile_id LONG,
    FOREIGN KEY(profile_id) REFERENCES profile
);

