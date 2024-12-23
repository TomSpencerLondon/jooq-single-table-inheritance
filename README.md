# jOOQ Single Table Inheritance Example

This project demonstrates how to implement Single Table Inheritance using jOOQ and Spring Boot. It showcases how to store different types of vehicles (Cars and Trucks) in a single database table while maintaining type-specific attributes.

## Single Table Inheritance Pattern

The application uses a single table called `vehicle` to store different types of vehicles:

```sql
CREATE TABLE vehicle (
    id               SERIAL PRIMARY KEY,
    type             VARCHAR(50) NOT NULL,
    manufacturer     VARCHAR(100),
    seating_capacity INT,         -- Used by Car
    load_capacity    INT          -- Used by Truck
);
```

The inheritance hierarchy is:
- `Vehicle` (abstract base class)
  - `Car` (with seating capacity)
  - `Truck` (with load capacity)

## Technical Stack

- Spring Boot 3.4
- jOOQ 3.18.7
- H2 Database (in-memory)
- Flyway for database migrations

## How to Run

1. Clone the repository
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```
   This will:
   - Create an in-memory H2 database
   - Run Flyway migrations
   - Generate jOOQ classes
   - Start the Spring Boot application

## API Endpoints

### Add a Car
```bash
curl -X POST http://localhost:8080/vehicles \
  -H "Content-Type: application/json" \
  -d '{
    "type": "CAR",
    "manufacturer": "Toyota",
    "seatingCapacity": 5
  }'
```

### Add a Truck
```bash
curl -X POST http://localhost:8080/vehicles \
  -H "Content-Type: application/json" \
  -d '{
    "type": "TRUCK",
    "manufacturer": "Volvo",
    "loadCapacity": 5000
  }'
```

### Get All Vehicles
```bash
curl http://localhost:8080/vehicles
```

## Implementation Details

### Database Layer
- Uses jOOQ for type-safe SQL queries
- Flyway manages database schema migrations
- H2 in-memory database for development

### Domain Model
- `Vehicle`: Abstract base class with common attributes (id, manufacturer)
- `Car`: Extends Vehicle, adds seatingCapacity
- `Truck`: Extends Vehicle, adds loadCapacity

### Repository Layer
The `VehicleRepository` class demonstrates how to:
- Map database records to appropriate vehicle types based on the 'type' column
- Handle type-specific attributes during insertion
- Use jOOQ's type-safe DSL for database operations

### Service Layer
The `VehicleService` provides business logic and transaction management.

### Controller Layer
The `VehicleController` handles HTTP requests and demonstrates:
- Type-based object creation
- JSON serialization of polymorphic objects
- RESTful endpoint design

## Database Console

Access the H2 console at http://localhost:8080/h2-console with:
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: sa
- Password: password
