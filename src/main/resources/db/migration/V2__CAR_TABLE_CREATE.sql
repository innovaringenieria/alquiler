CREATE TABLE carro
(
    id              INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    modelo          VARCHAR(255)                             NOT NULL,
    marca           VARCHAR(255)                             NOT NULL,
    data_fabricacao date                                     NOT NULL,
    CONSTRAINT pk_carro PRIMARY KEY (id)
);