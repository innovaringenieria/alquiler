CREATE TABLE empleado
(
    id        INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    nome      VARCHAR(255)                             NOT NULL,
    matricula INTEGER                                  NOT NULL,
    CONSTRAINT pk_empleado PRIMARY KEY (id)
);