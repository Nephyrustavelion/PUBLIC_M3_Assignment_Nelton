package sg.edu.ntu.taskflow_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.ntu.taskflow_api.model.Task;
import sg.edu.ntu.taskflow_api.repository.TaskRepository;

// •	findAllTasks()
// •	findTaskById(Long id)
// •	createTask(Task task)
// •	updateTask(Long id, Task task)
// •	deleteTask(Long id)
// •	markTaskAsComplete(Long id)

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    // Create / Update
    // public Task save(Task task) {
    // return taskRepository.save(task);
    // }

    public Task findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        task.setId(null);
        return taskRepository.save(task);
    }

    // UPDATE TASK
    public Task updateTask(Long id, Task task) {
        Task existingTask = taskRepository.findById(id);

        if (existingTask != null) {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setCompletedFlag(task.getCompletedFlag());

            return taskRepository.save(existingTask);
        }
        return null;
    }

    public boolean deleteTask(Long id) {
        return taskRepository.deleteById(id);
    }

    public Task markTaskAsComplete(Long id) {
        Task existingTask = taskRepository.findById(id);

        if (existingTask != null) {
            existingTask.setCompletedFlag(true);
            return taskRepository.save(existingTask);
        }
        return null;
    }

}
