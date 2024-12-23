CREATE TABLE IF NOT EXISTS vehicle (
    id               SERIAL PRIMARY KEY,
    type             VARCHAR(50) NOT NULL,
    manufacturer     VARCHAR(100),
    seating_capacity INT,
    load_capacity    INT
);
