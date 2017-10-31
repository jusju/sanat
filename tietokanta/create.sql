CREATE TABLE Henkilot (
    id INT NOT NULL AUTO_INCREMENT,
    kayttajatunnus VARCHAR(90),
    salasana VARCHAR(300),
    suola VARCHAR(200),
    PRIMARY KEY (id)
)engine=innodb DEFAULT CHARSET=utf8;

CREATE TABLE Sanat (
    id INT NOT NULL AUTO_INCREMENT,
    aika TIMESTAMP NOT NULL,
    sana VARCHAR(90) NOT NULL,
    seloste VARCHAR(300) NOT NULL,
    kayttaja_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (kayttaja_id) REFERENCES Henkilot(id)
)engine=innodb DEFAULT CHARSET=utf8;