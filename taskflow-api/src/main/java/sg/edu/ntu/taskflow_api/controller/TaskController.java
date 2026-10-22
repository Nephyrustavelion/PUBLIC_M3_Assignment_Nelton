package sg.edu.ntu.taskflow_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import sg.edu.ntu.taskflow_api.model.Task;
import sg.edu.ntu.taskflow_api.service.TaskService;

// GET	/api/tasks	Get all tasks
// GET	/api/tasks/{id}	Get one task by id
// POST	/api/tasks	Create a new task
// PUT	/api/tasks/{id}	Update an existing task
// DELETE	/api/tasks/{id}	Delete a task
// PUT	/api/tasks/{id}/complete	Mark a task as complete
// Return the correct status codes. 201 for create, 200 for the rest.
// Use constructor injection to bring the service into the controller.

@RestController
@RequestMapping("/api/tasks")

public class TaskController {

    private final TaskService taskService;
    // 200 for the rest of the operations

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.findAllTasks();
        // Return 200 status code for successful retrieval
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
    //     Task task = taskService.findTaskById(id);
    //     return ResponseEntity.status(HttpStatus.OK).body(task);
    // }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        // Return 201 status code for create
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
    //     Task updatedTask = taskService.updateTask(id, task);
    //     return ResponseEntity.status(HttpStatus.OK).body(updatedTask);
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
    //     taskService.deleteTask(id);
    //     return ResponseEntity.status(HttpStatus.OK).build();
    // }

    // @PutMapping("/{id}/complete")
    // public ResponseEntity<Task> markTaskAsComplete(@PathVariable Long id) {
    //     Task completedTask = taskService.markTaskAsComplete(id);
    //     return ResponseEntity.status(HttpStatus.OK).body(completedTask);
    // }

    //

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.findTaskById(id);

        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @RequestBody Task task) {

        Task updatedTask = taskService.updateTask(id, task);

        if (updatedTask == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        boolean deleted = taskService.deleteTask(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Task> markTaskAsComplete(@PathVariable Long id) {
        Task completedTask = taskService.markTaskAsComplete(id);

        if (completedTask == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(completedTask);
    }

}
