package main;

import main.model.Task;
import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private static int taskCount;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void addTask(Task task) {
        Task newTask = taskRepository.save(task);
        newTask.setId(++taskCount);
    }

    @Override
    public void delete(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void editTask(int id, Task updateTask) {
        taskRepository.deleteById(id);
        taskRepository.save(updateTask);
    }

    @Override
    public List<Task> list() {
        Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable) {
            tasks.add(task);
        }
        return tasks;
    }

    @Override
    public Task show(int id) {
        return list().stream().filter(task -> task.getId() == id).findAny().orElse(null);
    }
}
