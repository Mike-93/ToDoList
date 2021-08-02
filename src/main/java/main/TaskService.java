package main;

import main.model.Task;

import java.util.List;

public interface TaskService {

    void addTask(Task task);

    void delete(int id);

    void editTask(int id, Task updateTask);

    List<Task> list();

    Task show(int id);
}
