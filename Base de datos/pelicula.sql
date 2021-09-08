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
