package pl.tm.hardwareinventory.service;

import pl.tm.hardwareinventory.model.Task;
import pl.tm.hardwareinventory.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getTasks();

    void add (Task task);

    Optional<Task> get(Long id);

    void delete(Long id);

    void update(Task task);

    int number();

    Optional<Task> getTaskFromId(Long id);

    int numberActiveTask();

    List<Task> getTasksByTitle(String title);



}
