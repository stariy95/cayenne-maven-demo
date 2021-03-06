CREATE TABLE ARTIST (DATE_OF_BIRTH DATE NULL, ID INT NOT NULL AUTO_INCREMENT, NAME VARCHAR(200) NULL, PRIMARY KEY (ID)) ENGINE=InnoDB;

CREATE TABLE GALLERY (ID INT NOT NULL AUTO_INCREMENT, NAME VARCHAR(200) NULL, PRIMARY KEY (ID)) ENGINE=InnoDB;

CREATE TABLE PAINTING (ARTIST_ID INT NULL, GALLERY_ID INT NULL, ID INT NOT NULL AUTO_INCREMENT, NAME VARCHAR(200) NULL, PRIMARY KEY (ID)) ENGINE=InnoDB;

ALTER TABLE PAINTING ADD FOREIGN KEY (ARTIST_ID) REFERENCES ARTIST (ID) ON DELETE CASCADE;

ALTER TABLE PAINTING ADD FOREIGN KEY (GALLERY_ID) REFERENCES GALLERY (ID) ON DELETE CASCADE;
