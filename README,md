# TaskFlow API – Module 3 Assignment

This is my End of Module 3 assignment for the NTU SCTP AI Engineering course.

I built a simple **Task Management REST API** using Java and Spring Boot. The application allows users to create, view, update, delete and mark tasks as completed.

## Technologies Used

- Java 21
- Spring Boot
- Maven
- Lombok
- HashMap (in-memory storage)
- Postman (API testing)

## What I Implemented

I structured the project using four layers:

- **Model** – Created a `Task` class with `id`, `title`, `description` and `completedFlag`.
- **Repository** – Used a `HashMap` to store tasks in memory and generate task IDs.
- **Service** – Implemented the logic for creating, retrieving, updating, deleting and completing tasks.
- **Controller** – Created REST endpoints using Spring Boot annotations.

I also practised constructor-based dependency injection, used `ResponseEntity` for HTTP responses, and added basic global exception handling.

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/tasks` | Get all tasks |
| GET | `/api/tasks/{id}` | Get task by ID |
| POST | `/api/tasks` | Create a task |
| PUT | `/api/tasks/{id}` | Update a task |
| DELETE | `/api/tasks/{id}` | Delete a task |
| PUT | `/api/tasks/{id}/complete` | Mark task as completed |

## Example JSON

To create a task using POST `/api/tasks`:

```json
{
  "title": "Complete Module 3 Assignment",
  "description": "Build a TaskFlow API using Spring Boot",
  "completedFlag": false
}
```

The task ID is generated automatically.

## Running the Application

From the project folder containing `pom.xml`:

```bash
mvn spring-boot:run
```

The default API address is:

`http://localhost:8080/api/tasks`

To run on port 8081 instead:

```bash
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
```

The endpoints can be tested using Postman:
POST
http://localhost:8081/api/tasks
{
    "id": 1,
    "title": "Study Spring AI",
    "description": "Learn ChatClient and OpenAI integration with Spring Boot",
    "completedFlag": true
},
{
    "id": 2,
    "title": "Complete Module 3 Assignment",
    "description": "Build and test TaskFlow API using Spring Boot",
    "completedFlag": false
}

GET
http://localhost:8081/api/tasks

PUT
http://localhost:8081/api/tasks/1

DELETE
http://localhost:8081/api/tasks/1

## Notes

- Tasks are stored in a HashMap, not a database.
- All stored tasks are lost when the application restarts.
- Spring AI was included during initial setup but its dependency was commented out to focus on the mandatory CRUD functionality.

## What I Learned

This assignment helped me practise Java OOP concepts, HashMap operations, Spring Boot annotations, dependency injection and layered architecture.

I also gained more experience troubleshooting Maven compilation errors, Spring Boot startup errors, and testing HTTP endpoints using Postman.
