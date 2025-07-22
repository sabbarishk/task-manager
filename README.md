<<<<<<< HEAD
# Task Management System

A Spring Boot REST API application for managing tasks with full CRUD operations.

## Features

- **Complete CRUD Operations**: Create, Read, Update, Delete tasks
- **REST API Endpoints**: RESTful web services
- **Task Management**: 
  - Task status tracking (PENDING, IN_PROGRESS, COMPLETED, CANCELLED)
  - Priority levels (LOW, MEDIUM, HIGH, URGENT)
  - Due date management
- **Advanced Queries**: Search by title, filter by status/priority
- **Data Validation**: Input validation with proper error handling
- **Exception Handling**: Global exception handler with custom error responses
- **H2 Database**: In-memory database for easy setup and testing
- **API Documentation**: Well-structured endpoints

## Technology Stack

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **H2 Database**
- **Maven**
- **Bean Validation**

## API Endpoints

### Task Operations
- `GET /api/tasks` - Get all tasks
- `GET /api/tasks/{id}` - Get task by ID
- `POST /api/tasks` - Create new task
- `PUT /api/tasks/{id}` - Update task
- `DELETE /api/tasks/{id}` - Delete task

### Advanced Operations
- `GET /api/tasks/status/{status}` - Get tasks by status
- `GET /api/tasks/priority/{priority}` - Get tasks by priority
- `GET /api/tasks/search?title={title}` - Search tasks by title
- `PATCH /api/tasks/{id}/status?status={status}` - Update task status
- `GET /api/tasks/stats` - Get task statistics

## Getting Started

1. **Clone the repository**
2. **Navigate to project directory**
3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```
4. **Access the application**:
   - API Base URL: http://localhost:8080/api/tasks
   - H2 Console: http://localhost:8080/h2-console

## Sample API Usage

### Create a Task
```json
POST /api/tasks
{
  "title": "New Task",
  "description": "Task description",
  "priority": "HIGH",
  "status": "PENDING",
  "dueDate": "2025-07-25T10:00:00"
}
```

### Update Task Status
```
PATCH /api/tasks/1/status?status=COMPLETED
```

## Resume Highlights

This project demonstrates:
- **Spring Boot** expertise with modern Java development
- **REST API** design and implementation
- **Database** integration with JPA/Hibernate
- **Exception Handling** and validation
- **Clean Architecture** with proper layering (Controller, Service, Repository)
- **DTOs** for proper data transfer
- **Custom Queries** and repository methods
- **Professional** code structure and documentation

## Project Structure

```
src/main/java/com/example/taskmanager/
├── TaskManagerApplication.java
├── controller/
│   └── TaskController.java
├── service/
│   └── TaskService.java
├── repository/
│   └── TaskRepository.java
├── model/
│   ├── Task.java
│   ├── TaskStatus.java
│   └── Priority.java
├── dto/
│   ├── TaskRequest.java
│   └── TaskResponse.java
└── exception/
    ├── TaskNotFoundException.java
    └── GlobalExceptionHandler.java
```
=======
# task-manager
>>>>>>> 1047c25a2b5a9adec1c2c2540c1ba1666d6036ba
