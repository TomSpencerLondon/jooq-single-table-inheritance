CREATE TABLE vehicle
(
    id               SERIAL PRIMARY KEY,
    type             VARCHAR(50) NOT NULL, -- Discriminator column
    manufacturer     VARCHAR(100),
    seating_capacity INT,                  -- Specific to cars
    load_capacity    INT                   -- Specific to trucks
);
