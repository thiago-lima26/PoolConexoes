CREATE DATABASE BDteste;

USE BDteste;

CREATE TABLE users (id int(10) NOT NULL AUTO_INCREMENT, 
username varchar(20) DEFAULT NULL, senha varchar(20) DEFAULT NULL, PRIMARY KEY (id));

INSERT INTO users (id, username, senha) VALUES (1, 'Thiago Lima', '123456');
INSERT INTO users (id, username, senha) VALUES (2, 'João Victor', '123456');
INSERT INTO users (id, username, senha) VALUES (3, 'Pedro Lucca', '123456');

SELECT * FROM users;
