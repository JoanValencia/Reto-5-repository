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
