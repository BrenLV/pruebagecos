CREATE DATABASE gecosdb;

CREATE TABLE IF NOT EXISTS categories
(
    id           SERIAL       NOT NULL PRIMARY KEY UNIQUE,
	version		 BIGINT		  NOT NULL,
    name         VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS products
(
    id           SERIAL       NOT NULL PRIMARY KEY UNIQUE,
	category_id  INTEGER      NOT NULL REFERENCES categories (id),
    active		 BOOLEAN      NOT NULL,
	currency     VARCHAR(255) NOT NULL,
    name         VARCHAR(255) NOT NULL,
	description  VARCHAR(255) NOT NULL,
	price		 DECIMAL	  NOT NULL,
	stock		 DECIMAL	  NOT NULL
);