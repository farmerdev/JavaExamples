DROP TABLE personas if exists;
CREATE TABLE personas
(
	dni VARCHAR(10) NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	apellidos VARCHAR(50),
	PRIMARY KEY (dni)
);
