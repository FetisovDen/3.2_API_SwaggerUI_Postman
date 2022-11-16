CREATE TABLE cars
(
    id    INTEGER PRIMARY KEY,
    brand TEXT    NOT NULL,
    model TEXT    NOT NULL,
    price NUMERIC NOT NULL,
    CONSTRAINT brand_model_unique UNIQUE (brand, model)

);
CREATE TABLE humans
(
    id    INTEGER PRIMARY KEY,
    name  TEXT    NOT NULL,
    age   INTEGER NOT NULL,
    availability_license BOOLEAN NOT NULL,
);

CREATE TABLE drivers
(
    id_human INTEGER PRIMARY KEY REFERENCES humans (id),
    name     TEXT    NOT NULL,
    car_id   INTEGER NOT NULL REFERENCES cars (id)
);