# Student Management System -- Spring Boot + MySQL

This project is a **Student Management REST API** built using **Spring
Boot 3**, **Spring Data JPA**, **MySQL**, and **Jakarta Validation**.\
It supports full CRUD operations along with input validation and global
exception handling.


------------------------------------------------------------------------

## Features

-   Create a new student\
-   Retrieve all students\
-   Retrieve a student by ID\
-   Update a student\
-   Delete a student\
-   Input validation using Jakarta Validation\
-   Proper HTTP status codes\
-   Global exception handling (`@RestControllerAdvice`)\
-   Layered architecture (Controller → Service → Repository)\
-   DTO usage for request/response\
  

------------------------------------------------------------------------

## Technologies Used

-   **Java 17**
-   **Spring Boot 3+**
-   **Spring Web**
-   **Spring Data JPA**
-   **MySQL**
-   **Jakarta Validation**
  

------------------------------------------------------------------------

## Project Structure

    com.example.StudentManagement
     ├── controller
     ├── dto
     ├── exception
     ├── model
     ├── repository
     ├── service
     └── StudentManagementApplication

------------------------------------------------------------------------

## How to Run the Project

### 1. Clone the project

``` bash
git clone https://github.com/sareenAhamed/StudentManagement.git
```

### 2. Configure MySQL in `application.properties`

Edit:

    src/main/resources/application.properties

Use:

``` properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

### 3. Build & Run

``` bash
mvn spring-boot:run
```

------------------------------------------------------------------------

## REST API Endpoints

### **1. Create Student**

    POST /api/v1/students

Request Body:

``` json
{
  "name": "Sareen Ahamed",
  "email": "sareen@example.com",
  "course": "Computer Science",
  "age": 24
}
```

------------------------------------------------------------------------

### **2. Get All Students**

    GET /api/v1/students

------------------------------------------------------------------------

### **3. Get Student by ID**

    GET /api/v1/students/{id}

------------------------------------------------------------------------

### **4. Update Student**

    PUT /api/v1/students/{id}

Request Body:

``` json
{
  "name": "Ahamed Updated",
  "email": "ahamed.updated@example.com",
  "course": "Software Engineering",
  "age": 22
}
```

------------------------------------------------------------------------

### **5. Delete Student**

    DELETE /api/v1/students/{id}

------------------------------------------------------------------------

## Validation Rules

  Field    Rule
  -------- ------------------------
  name     must not be blank
  email    must be valid & unique
  course   must not be blank
  age      must be ≥ 19

------------------------------------------------------------------------

## Global Exception Handling

Handled exceptions: - `ResourceNotFoundException` → **404 Not Found** -
`MethodArgumentNotValidException` → **400 Bad Request** - `Exception` →
**500 Internal Server Error**

All responses include: - timestamp\
- status\
- error/message\
- list of validation errors (if any)


------------------------------------------------------------------------

## Conclusion

This project demonstrates: - REST API design principles\
- Use of Spring Boot + JPA\
- Proper layering (Controller → Service → Repository)\
- Use of DTOs\
- MySQL Integration\
- Exception handling\
- Validation with Jakarta

------------------------------------------------------------------------

## ✅ Author

**Sareen Ahamed**\
BICT Undergraduate -- Faculty of Technology\
University of Sri Jayewardenepura
