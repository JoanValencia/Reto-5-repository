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
