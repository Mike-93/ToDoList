package main;

import main.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {

    private static int currentId = 1;

    private static HashMap<Integer, Task> tasks = new HashMap<>();

    public static int addTask(Task task) {
        int id = currentId++;
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    public static synchronized int removeTask(int id) {
        tasks.remove(id);
        return tasks.size();
    }

    public static synchronized int editTask(int id, Task task) {
        tasks.remove(id);
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    public static List<Task> getAllTasks() {
        ArrayList<Task> allTasks = new ArrayList<>();
        allTasks.addAll(tasks.values());
        return allTasks;
    }

    public static int removeAllTasks() {
        tasks.clear();
        return tasks.size();
    }

}
