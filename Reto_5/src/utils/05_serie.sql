CREATE TABLE series(
    ser_id			int AUTO_INCREMENT PRIMARY KEY,
    cont_id 		int NOT NULL,
    ser_episodios	int NOT NULL,
    ser_temporadas	int NOT NULL,
    FOREIGN  KEY(cont_id) REFERENCES contenidos(cont_id)
);
INSERT INTO series(cont_id, ser_episodios, ser_temporadas) VALUES (6, 153, 11);
INSERT INTO series(cont_id, ser_episodios, ser_temporadas) VALUES (7, 80, 3);
INSERT INTO series(cont_id, ser_episodios, ser_temporadas) VALUES (8, 30, 3);
INSERT INTO series(cont_id, ser_episodios, ser_temporadas) VALUES (9, 31, 4);
INSERT INTO series(cont_id, ser_episodios, ser_temporadas) VALUES (10, 236, 10);
INSERT INTO series(cont_id, ser_episodios, ser_temporadas) VALUES (11, 170, 8);
INSERT INTO series(cont_id, ser_episodios, ser_temporadas) VALUES (12, 279, 12);
INSERT INTO series(cont_id, ser_episodios, ser_temporadas) VALUES (13, 79, 6);
