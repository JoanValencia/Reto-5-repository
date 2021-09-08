DROP SCHEMA IF EXISTS reto_4;
CREATE SCHEMA reto_4 DEFAULT CHARACTER SET utf8;
USE  reto_4;

DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS transmisiones;
DROP TABLE IF EXISTS director;
DROP TABLE IF EXISTS pelicula;
DROP TABLE IF EXISTS serie;
DROP TABLE IF EXISTS contenidos;

CREATE TABLE usuarios(
    usr_username	varchar(15) PRIMARY KEY,
    usr_nombres		varchar(30) NOT NULL,
	usr_apellidos 	varchar(30) NOT NULL,
    usr_email     	varchar(25) NOT NULL,
	usr_celular    	varchar(12) NOT NULL,
    usr_contrasena	varchar(12) NOT NULL,
    usr_fechaNacim	date NOT NULL
);
INSERT INTO usuarios VALUES ("lucky", "Pedro","Perez", "pperez@hotmail.com","3212345677","manzana52",'1985-06-25');
INSERT INTO usuarios VALUES ("malopez","Maria","Lopez","malo@gmail.com","3504468950","sheetfile1",'1999-08-01');
INSERT INTO usuarios VALUES ("diva","Ana","Diaz","anita@yahoo.es","3002854555","De$count567",'1992-01-15');
INSERT INTO usuarios VALUES ("dreamer","Luis","Rojas","larojas@gmail.com","3012108958","Perrogato99",'1974-12-24');
INSERT INTO usuarios VALUES ("ninja","Andres","Cruz","ninjacruz@hotmail.com","3154007887","Passninja865",'2001-04-05');
INSERT INTO usuarios VALUES ("neon","Nelson","Ruiz","neru95@gmail.com","3002565587","Prueba8967",'1952-11-02');
INSERT INTO usuarios VALUES ("rose","Claudia","Mendez","claudis1a@hotmail.com","3025662322","manzana0546",'2011-11-05');
INSERT INTO usuarios VALUES ("green","Jorge","Rodriguez","jorgerodva@yahoo.com","3044022114","Bookface3454",'2000-03-28');

select * from usuarios;

CREATE TABLE contenidos(
    cont_id			int AUTO_INCREMENT PRIMARY KEY,
	cont_titulo		varchar(50) NOT NULL
);
INSERT INTO contenidos (cont_titulo) VALUES ("Los Vengadores");
INSERT INTO contenidos (cont_titulo) VALUES ("Interestelar");
INSERT INTO contenidos (cont_titulo) VALUES ("El viaje de Chihiro");
INSERT INTO contenidos (cont_titulo) VALUES ("Parasitos");
INSERT INTO contenidos (cont_titulo) VALUES ("Mas alla de los sueños");
INSERT INTO contenidos (cont_titulo) VALUES ("The walking dead");
INSERT INTO contenidos (cont_titulo) VALUES ("Viaje a las estrellas: la serie original");
INSERT INTO contenidos (cont_titulo) VALUES ("Glow");
INSERT INTO contenidos (cont_titulo) VALUES ("La casa de papel");
INSERT INTO contenidos (cont_titulo) VALUES ("Friends");
INSERT INTO contenidos (cont_titulo) VALUES ("Arrow");
INSERT INTO contenidos (cont_titulo) VALUES ("The big bang theory");
INSERT INTO contenidos (cont_titulo) VALUES ("Vikingos");

select * from contenidos;

CREATE TABLE director(
    dir_id				int AUTO_INCREMENT PRIMARY KEY,
    dir_nombre			varchar(30) NOT NULL,
    dir_apellido		varchar(30) NOT NULL,
    dir_nacionalidad	varchar(50) NOT NULL
);
INSERT INTO director VALUES (101, "Hayo","Miyazaki", "japones");
INSERT INTO director VALUES (102, "Joss", "Whedon", "estadounidense");
INSERT INTO director VALUES (103, "Christopher", "Nolan", "estadounidense");
INSERT INTO director VALUES (104, "Bong", "Joon-ho", "coreano");
INSERT INTO director VALUES (105, "Vincent", "Ward", "neozelandes");

select * from director;


CREATE TABLE serie(
    ser_id			int AUTO_INCREMENT PRIMARY KEY,
    cont_id 		int NOT NULL,
    ser_episodios	int NOT NULL,
    ser_temporadas	int NOT NULL,
    FOREIGN  KEY(cont_id) REFERENCES contenidos(cont_id)
);
INSERT INTO serie(cont_id, ser_episodios, ser_temporadas) VALUES (6, 153, 11);
INSERT INTO serie(cont_id, ser_episodios, ser_temporadas) VALUES (7, 80, 3);
INSERT INTO serie(cont_id, ser_episodios, ser_temporadas) VALUES (8, 30, 3);
INSERT INTO serie(cont_id, ser_episodios, ser_temporadas) VALUES (9, 31, 4);
INSERT INTO serie(cont_id, ser_episodios, ser_temporadas) VALUES (10, 236, 10);
INSERT INTO serie(cont_id, ser_episodios, ser_temporadas) VALUES (11, 170, 8);
INSERT INTO serie(cont_id, ser_episodios, ser_temporadas) VALUES (12, 279, 12);
INSERT INTO serie(cont_id, ser_episodios, ser_temporadas) VALUES (13, 79, 6);

select * from serie;


CREATE TABLE pelicula(
    pel_id			int AUTO_INCREMENT PRIMARY KEY,
    cont_id			int NOT NULL,
    dir_id			int NOT NULL,
    pel_resumen		varchar(500) NOT NULL,
    pel_anio		int NOT NULL,
    FOREIGN KEY(cont_id) REFERENCES contenidos(cont_id),
    FOREIGN KEY(dir_id) REFERENCES director(dir_id)
);
INSERT INTO pelicula(cont_id,dir_id,pel_resumen,pel_anio) VALUES (1,102,"Pelicula de superheroes basada en Marvel Comics. Nick Fury director de SHIELD recluta a Tony Stark, Steve Rogers, Bruce Banner y Thor para forma un equipo y evitar que Loki, hermano de Thor, se apodere de la tierra.",1990);
INSERT INTO pelicula(cont_id,dir_id,pel_resumen,pel_anio) VALUES (2,103,"Pelicula de ciencia ficción, donde la humanidad lucha por sobrevivir. La pelicula cuenta una historia de un grupo de astronautas que viajan a traves de un agujero de gusano en busca de un nuevo hogar.",2014);
INSERT INTO pelicula(cont_id,dir_id,pel_resumen,pel_anio) VALUES (3,101,"Pelicula de animación japonesa. Es la historia de una niña de 12 años, quien se ve atrapada por un mundo mágico y sobrenatural, teniendo como misión buscar su libertad y la de sus padres y regresar al mundo real.",2001);
INSERT INTO pelicula(cont_id,dir_id,pel_resumen,pel_anio) VALUES (4,104,"Pelicula de drama, suspenso y humor negro. Toca temas como las diferencias sociales y vulnerabilidad del espiritu humano.",2019);
INSERT INTO pelicula(cont_id,dir_id,pel_resumen,pel_anio) VALUES (5,105,"Pelicula de drama, narra una historia trágica de una familia, donde el padre va en busca de sus esposa al mas allá para recuperarla.",1998);

select * from pelicula;

CREATE TABLE transmisiones(
    trans_id		int AUTO_INCREMENT PRIMARY KEY,
    usr_username	varchar(15) NOT NULL,
    cont_id			int NOT NULL,
	trans_fecha		datetime NOT NULL,
    FOREIGN  KEY(usr_username) REFERENCES  usuarios(usr_username),
    FOREIGN  KEY(cont_id) REFERENCES  contenidos(cont_id)
);
INSERT INTO transmisiones(usr_username, cont_id, trans_fecha) VALUES ("lucky", 1, '2017-10-25 20:00:00');
INSERT INTO transmisiones(usr_username, cont_id, trans_fecha) VALUES ("lucky", 4, '2019-03-15 18:30:00');
INSERT INTO transmisiones(usr_username, cont_id, trans_fecha) VALUES ("lucky", 9, '2019-05-20 20:30:00');
INSERT INTO transmisiones(usr_username, cont_id, trans_fecha) VALUES ("malopez",1,'2018-05-20 20:30:00');
INSERT INTO transmisiones(usr_username, cont_id, trans_fecha) VALUES ("malopez",9,'2020-01-20 20:30:00');
INSERT INTO transmisiones(usr_username, cont_id, trans_fecha) VALUES ("diva", 2, '2019-05-20 20:30:00');
INSERT INTO transmisiones(usr_username, cont_id, trans_fecha) VALUES ("diva", 3, '2018-06-22 21:30:00');
INSERT INTO transmisiones(usr_username, cont_id, trans_fecha) VALUES ("diva", 6, '2020-03-17 15:30:20');
INSERT INTO transmisiones(usr_username, cont_id, trans_fecha) VALUES ("dreamer",6,'2020-03-17 15:30:20');
INSERT INTO transmisiones(usr_username, cont_id, trans_fecha) VALUES ("dreamer",7,'2020-04-10 18:30:20');
INSERT INTO transmisiones(usr_username, cont_id, trans_fecha) VALUES ("ninja", 8, '2020-02-17 20:30:20');
INSERT INTO transmisiones(usr_username, cont_id, trans_fecha) VALUES ("ninja", 9, '2020-02-20 16:30:20');
INSERT INTO transmisiones(usr_username, cont_id, trans_fecha) VALUES ("ninja", 11, '2020-03-27 18:30:20');
INSERT INTO transmisiones(usr_username, cont_id, trans_fecha) VALUES ("rose", 10, '2020-03-20 21:30:20');
INSERT INTO transmisiones(usr_username, cont_id, trans_fecha) VALUES ("green",2,'2020-01-10 17:30:20');
INSERT INTO transmisiones(usr_username, cont_id, trans_fecha) VALUES ("green",4,'2020-02-15 20:30:20');
INSERT INTO transmisiones(usr_username, cont_id, trans_fecha) VALUES ("green",5,'2020-03-17 18:30:20');

select * from transmisiones;


UPDATE pelicula SET pel_anio = 2012 WHERE cont_id = 1;
UPDATE usuarios SET usr_celular = 3115678432 WHERE usr_username = "ninja";
DELETE FROM transmisiones WHERE usr_username = "green" AND cont_id = 4; 


SELECT 'Consulta 1';
SELECT cont_titulo FROM contenidos ORDER BY cont_titulo;
SELECT 'Consulta 2';
SELECT c.cont_titulo, p.pel_resumen, p.pel_anio FROM contenidos c INNER JOIN pelicula p ON  c.cont_id = p.cont_id WHERE p.pel_Anio > 2000 ORDER BY cont_titulo;
SELECT 'Consulta 3';
SELECT c.cont_titulo FROM contenidos c INNER JOIN pelicula p ON c.cont_id = p.cont_id WHERE dir_id = 105;
SELECT 'Consulta 4';
SELECT c.cont_Titulo FROM contenidos c INNER JOIN transmisiones t ON c.cont_id = t.cont_id WHERE usr_username = "lucky";
SELECT 'Consulta 5';
SELECT u.usr_username, u.usr_nombres, u.usr_apellidos FROM usuarios u INNER JOIN transmisiones t ON t.usr_username = u.usr_username WHERE cont_id = 2 ORDER BY u.usr_nombres;
SELECT 'Consulta 6';
SELECT c.cont_titulo FROM contenidos c INNER JOIN pelicula p ON c.cont_id = p.cont_id WHERE p.pel_anio > 2000;



