package pl.tm.hardwareinventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tm.hardwareinventory.model.Task;
import pl.tm.hardwareinventory.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class JpaTaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    @Override
    public List<Task> getTasks() {
        return this.taskRepository.findAll();
    }

    @Override
    public void add(Task task) {
        this.taskRepository.save(task);
    }

    @Override
    public Optional<Task> get(Long id) {
        return this.taskRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        this.taskRepository.deleteById(id);

    }

    @Override
    public void update(Task task) {
        this.taskRepository.save(task);
    }

    @Override
    public int number() {
        return (int) this.taskRepository.findAll().stream().count();
    }

    @Override
    public Optional<Task> getTaskFromId(Long id) {
        return this.taskRepository.findById(id);
    }
}
