CREATE TABLE users(
    id serial PRIMARY KEY,
    username varchar(255) NOT NULL,
    email varchar(100) NOT NULL,
    password varchar(255) NOT NULL
);