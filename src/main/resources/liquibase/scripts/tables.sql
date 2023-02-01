-- liquibase formatted sql

-- changeset Shkril:1

CREATE TABLE buyers (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL
);

CREATE TABLE sellers (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL
);

CREATE TABLE items (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       price DOUBLE NOT NULL
);

CREATE TABLE warehouses (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            item_id BIGINT NOT NULL,
                            quantity INT NOT NULL,
                            FOREIGN KEY (item_id) REFERENCES items(id)
);







