DROP TABLE IF EXISTS users;


CREATE TABLE users(
    email VARCHAR(255) PRIMARY KEY,
    NAME VARCHAR(255),
    PASSWORD VARCHAR(255),
    age INT
);