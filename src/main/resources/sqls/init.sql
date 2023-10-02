CREATE TABLE C_agenda(
    codigo int not null AUTO_INCREMENT,
    nome varchar(45) not null,
    PRIMARY KEY(codigo)
);

CREATE TABLE C_email(
    email varchar(100) not null,
    codigo int not null,
    PRIMARY KEY(email),
    FOREIGN KEY(codigo) REFERENCES C_agenda(codigo)
);

CREATE TABLE C_telefone(
    telefone int not null,
    codigo int not null,
    PRIMARY KEY(telefone),
    FOREIGN KEY(codigo) REFERENCES C_agenda(codigo)
);