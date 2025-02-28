# Book Inventory Management System

## Overview
This project is a **Book Inventory Management System** built using **Spring Boot**. It provides CRUD operations, book search functionality, stock management, and the ability to purchase books with proper exception handling.

## Features
- Add, Update, Delete, and View Books
- Search Books by Title
- Purchase Books with Stock Validation
- Exception Handling for Out of Stock and Invalid Quantity
- Logging with SLF4J
- Unit Testing using JUnit and Mockito

## Technology Stack
- **Java 17**
- **Spring Boot 3.x**
- **H2 Database (In-Memory)**
- **JUnit 5**
- **Mockito**
- **SLF4J**

## Project Structure
```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── rahulsharma
│   │   │           └── BookingInventory
│   │   │               ├── entity
│   │   │               │   └── Book.java
│   │   │               ├── repository
│   │   │               │   └── BookRepository.java
│   │   │               ├── service
│   │   │               │   └── BookService.java
│   │   │               ├── controller
│   │   │               │   └── BookingController.java
│   │   │               ├── exception
│   │   │               │   ├── InsufficientStockException.java
│   │   │               │   └── GlobalExceptionHandler.java
│   │   │               └── BookingInventoryApplication.java
│   └── test
│       └── java
│           └── com
│               └── rahulsharma
│                   └── BookingInventory
│                       └── BookingInventoryApplicationTest.java
└── pom.xm

   ```
## How to Run the Project
### Prerequisites
- Install **Java 17 or above**
- Install **Maven**

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/rahulsharma9001/Booking-Inventory-Management-System.git
   ```
2. Build the Project:
   ```bash
   mvn clean install
   ```

3. Run the Application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the API:
   - Get All Books: `GET http://localhost:8080/books`
   - Search Books by Title: `GET http://localhost:8080/books/search?title="**Book-Title**"`
   - Add Book: `POST http://localhost:8080/books/addBook`
   - Purchase Book: `PUT http://localhost:8080/books/purchase/{id}?quantity={quantity}`
   - Delete Book: `DELETE http://localhost:8080/books/{id}`
   - Update Book: `PUT http://localhost:8080/books/{id}`

## Testing
Run Unit Tests:
```bash
mvn test
```

