package pl.tm.hardwareinventory.service;

import pl.tm.hardwareinventory.model.Task;

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



}
