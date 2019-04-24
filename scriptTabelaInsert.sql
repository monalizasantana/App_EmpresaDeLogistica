-- Table: veiculo

-- DROP TABLE veiculo;

CREATE TABLE veiculo
(
  id character varying(10),
  capacidade numeric(10,2),
  latitude numeric(10,2),
  longitude numeric(10,2),
  tipoveiculo character varying(3)
)

INSERT INTO veiculo(
            id, capacidade, latitude, longitude, tipoveiculo)
    VALUES (1, 22, 50, 23, T);

INSERT INTO veiculo(
            id, capacidade, latitude, longitude, tipoveiculo)
    VALUES (2, 53, 23, 44, T);

INSERT INTO veiculo(
            id, capacidade, latitude, longitude, tipoveiculo)
    VALUES (3, 22, 87, 56, T);

INSERT INTO veiculo(
            id, capacidade, latitude, longitude, tipoveiculo)
    VALUES (4, 15, 32, 85, D);

INSERT INTO veiculo(
            id, capacidade, latitude, longitude, tipoveiculo)
    VALUES (5, 22, 67, 32, D);

INSERT INTO veiculo(
            id, capacidade, latitude, longitude, tipoveiculo)
    VALUES (6, 34, 50, 15, D);
