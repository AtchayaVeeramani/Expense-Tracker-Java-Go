# Expense Tracker Backend

This is the backend service for an Expense Tracker application, developed using Java 21 and Spring Boot 3. The backend provides RESTful API endpoints to manage expense records, with full Create, Read, Update, and Delete (CRUD) functionality. Data persistence is managed using Spring Data JPA and an in-memory H2 database for development and testing.

---

## Project Overview

The Expense Tracker backend allows users to:

- Add new expenses.
- Retrieve all expenses or a specific expense by ID.
- Update existing expenses.
- Delete expenses.
- Persist expense data in an H2 in-memory database.
- Access the H2 database console for direct database inspection.

This project is designed to be extendable and ready for integration with a frontend application or additional microservices.

---

## Project Structure

backend/
├─ src/
│ ├─ main/
│ │ ├─ java/com/atchayaveeramani/backend/
│ │ │ ├─ BackendApplication.java # Spring Boot main application
│ │ │ ├─ Expense.java # Expense entity class annotated for JPA
│ │ │ ├─ ExpenseController.java # REST API controller for expenses
│ │ │ └─ ExpenseRepository.java # Spring Data JPA repository interface
│ │ └─ resources/
│ │ └─ application.properties # Application configuration (datasource, JPA, H2)
├─ build.gradle # Gradle build configuration
├─ gradlew, gradlew.bat # Gradle wrapper scripts
└─ README.md # This project documentation



## Development Process

### 1. Environment Setup  
- Installed Java 21 JDK and configured development environment with VS Code.  
- Initialized a Spring Boot 3 project using Gradle with necessary dependencies.

### 2. Defining the Expense Entity  
- Created `Expense.java` annotated with `@Entity` and `@Table` for JPA persistence.  
- Fields include `id`, `title`, `amount`, and `date`.  
- Used `@Id` and `@GeneratedValue` for automatic ID generation.

### 3. Building the REST Controller  
- Created `ExpenseController.java` with endpoints:  
  - `GET /expenses` to retrieve all expenses  
  - `POST /expenses` to add a new expense  
  - `GET /expenses/{id}` to retrieve an expense by ID  
  - `PUT /expenses/{id}` to update an expense  
  - `DELETE /expenses/{id}` to delete an expense

### 4. Setting up Persistence  
- Added Spring Data JPA and H2 dependencies in `build.gradle`.  
- Configured datasource and JPA properties in `application.properties` for H2 in-memory database.  
- Created `ExpenseRepository.java` interface extending `JpaRepository` for database interaction.

### 5. Testing and Verification  
- Used Postman and curl to test CRUD endpoints, validating JSON request and response.  
- Accessed the H2 database console at `http://localhost:8080/h2-console` to inspect the `expenses` table and data.

---

## Running the Application Locally

1. Clone the repository:
git clone https://github.com/yourusername/expense-tracker-java-go.git



2. Navigate to the backend folder:
cd expense-tracker-java-go/backend


3. Run the application:
- On Linux/Mac:
  ```
  ./gradlew bootRun
  ```
- On Windows:
  ```
  .\gradlew.bat bootRun
  ```

4. Access the API endpoints:  
- Get all expenses:  
  ```
  GET http://localhost:8080/expenses
  ```
- Add a new expense:  
  ```
  POST http://localhost:8080/expenses
  ```
  Body example (JSON):
  ```
  {
    "title": "Lunch",
    "amount": 12.75
  }
  ```
- Get expense by ID, update, or delete using respective endpoints.

5. View database content in H2 console:  
http://localhost:8080/h2-console

- JDBC URL: `jdbc:h2:mem:expensetrackerdb`  
- Username: `sa`  
- Password: (leave blank)

---

## API Documentation

### Endpoints:

| Method | Endpoint          | Description                 |
|--------|-------------------|-----------------------------|
| GET    | /expenses         | Retrieve all expenses        |
| POST   | /expenses         | Add a new expense            |
| GET    | /expenses/{id}    | Retrieve an expense by ID    |
| PUT    | /expenses/{id}    | Update an existing expense   |
| DELETE | /expenses/{id}    | Delete an expense by ID      |

---

## Future Improvements

- Add input validation with Spring Validation (`@Valid`, `@NotNull`, etc.).  
- Implement global exception handling with `@ControllerAdvice` for consistent error responses.  
- Write unit and integration tests with JUnit and Mockito.  
- Develop a frontend application to interact with this backend.  
- Secure the API using Spring Security for authentication and authorization.  
- Switch to a persistent database like MySQL/PostgreSQL for production deployment.  
- Set up CI/CD pipelines and deploy to cloud platforms such as AWS or Azure.

---

## Acknowledgements

This project was developed independently using Spring Boot, official documentation, tutorials, and best practices for RESTful API design and Java backend development.

---

Feel free to customize and extend this project according to your needs.
