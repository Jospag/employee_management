# Employee Management System - README

## Project Overview
This is a Spring Boot application that provides a RESTful API for managing employee data. The system allows for creating, reading, updating, and deleting employee records, as well as searching for employees by various criteria.

## Features
- Complete CRUD operations for employee management
- RESTful API endpoints
- Exception handling with appropriate HTTP status codes
- Input validation
- Search functionality
- API documentation with Swagger

## Technology Stack
- Java
- Spring Boot
- Spring Data JPA
- H2 Database (in-memory)
- Swagger for API documentation
- Lombok for reducing boilerplate code

## Project Structure
- `model`: Contains the Employee entity
- `repository`: Contains the JPA repository for database operations
- `service`: Contains the business logic layer
- `controller`: Contains the REST API endpoints
- `exception`: Contains custom exceptions and global exception handling
- `config`: Contains configuration classes

## API Endpoints

### Get all employees
```
GET /api/employees
```

### Get employee by ID
```
GET /api/employees/{id}
```

### Create new employee
```
POST /api/employees
```

### Update employee
```
PUT /api/employees/{id}
```

### Delete employee
```
DELETE /api/employees/{id}
```

### Search employees
```
GET /api/employees/search?keyword={keyword}
```

## Setup and Running the Application

### Prerequisites
- Java 8 or higher
- Maven

### Running the Application
1. Clone the repository
2. Navigate to the project directory
3. Run the application using Maven:
   ```
   mvn spring-boot:run
   ```
4. The application will start on port 8080
5. Access the H2 console at http://localhost:8080/h2-console
6. Access the Swagger UI at http://localhost:8080/swagger-ui.html

## Testing
The application includes unit tests for the service layer and integration tests for the controller layer.

## Future Enhancements
- Add authentication and authorization
- Implement pagination for large datasets
- Add more advanced search capabilities
- Create a frontend interface
