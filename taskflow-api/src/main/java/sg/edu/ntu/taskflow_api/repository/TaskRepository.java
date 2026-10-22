package sg.edu.ntu.taskflow_api.repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import sg.edu.ntu.taskflow_api.model.Task;
import org.springframework.stereotype.Repository;

// •	Store the tasks in memory. Choose either an ArrayList or a HashMap.
// •	If you use an ArrayList, you will need to loop through the list to find a task by its id. Write a small helper method for this.
// •	If you use a HashMap, you can look a task up directly by its key.
// •	Generate your own ids. A simple counter is enough.
// •	Initialise your collection so it is never null.

@Repository
public interface TaskRepository {

    // Store tasks in memory
    private final Map<Long, Task> taskMap = new HashMap<>();

    // Generate IDs
    private long nextId = 1;

    // Find all tasks
    public List<Task> findAll() {
        return new ArrayList<>(taskMap.values());
    }

    // Find task by UUID
    public Task findById(Long id) {
        return taskMap.get(id);
    }

    // Create or update task
    public Task save(Task task) {
        if (task.getId() == null) {
            task = new Task(nextId++, task.getTitle(), task.getDescription(), task.getCompletedFlag());
        }
        taskMap.put(task.getId(), task);
        return task;
    }

    // Delete task by UUID
    public boolean deleteById(Long id) {
        return taskMap.remove(id) != null;
    }
}
