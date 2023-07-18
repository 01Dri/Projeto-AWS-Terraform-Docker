CREATE TABLE cliente_login (
    id BIGINT  AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);