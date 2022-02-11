package pl.tm.hardwareinventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tm.hardwareinventory.dto.TaskUserHardwareSoftwareDTO;
import pl.tm.hardwareinventory.model.Task;
import pl.tm.hardwareinventory.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JpaTaskServiceImpl implements TaskService {

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

    @Override
    public int numberActiveTask() {
        return taskRepository.countActiveTask();
    }

    @Override
    public List<Task> getTasksByTitle(String title) {
        return taskRepository.findAllByTitle(title);
    }


    public List<TaskUserHardwareSoftwareDTO> getAllTaskUserHardwareSoftware() {
        return taskRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }



    private TaskUserHardwareSoftwareDTO convertEntityToDto(Task task){
        TaskUserHardwareSoftwareDTO taskUserHardwareSoftwareDTO = new TaskUserHardwareSoftwareDTO();
        taskUserHardwareSoftwareDTO.setTaskId(task.getId());
        taskUserHardwareSoftwareDTO.setCloseDate(task.getCloseDate());
        taskUserHardwareSoftwareDTO.setDescription(task.getDescription());
        taskUserHardwareSoftwareDTO.setLogDate(task.getLogDate());
        taskUserHardwareSoftwareDTO.setPriority(task.getPriority());
        taskUserHardwareSoftwareDTO.setStatus(task.getStatus());
        taskUserHardwareSoftwareDTO.setTitle(task.getTitle());

        if(task.getHardware() != null) {
            taskUserHardwareSoftwareDTO.setSerialNumber(task.getHardware().getSerialNumber());
            taskUserHardwareSoftwareDTO.setHardwareName(task.getHardware().getName());
            taskUserHardwareSoftwareDTO.setHardwareProducerName(task.getHardware().getName());
        }

        if(task.getSoftware()!= null) {
            taskUserHardwareSoftwareDTO.setSoftwareProducerName(task.getSoftware().getName());
            taskUserHardwareSoftwareDTO.setSoftwareName(task.getSoftware().getName());
        }
        if(task.getUser() != null){
            taskUserHardwareSoftwareDTO.setUsername(task.getUser().getUsername());
        }
        return taskUserHardwareSoftwareDTO;
    }





    public List<TaskUserHardwareSoftwareDTO> getAllTaskUserHardwareSoftwareStatusFalse() {
        return taskRepository.findAllWhereStatusIsFalse()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    private TaskUserHardwareSoftwareDTO convertEntityToDtoStatusFalse(Task task){
        TaskUserHardwareSoftwareDTO taskUserHardwareSoftwareDTO = new TaskUserHardwareSoftwareDTO();
        taskUserHardwareSoftwareDTO.setTaskId(task.getId());
        taskUserHardwareSoftwareDTO.setCloseDate(task.getCloseDate());
        taskUserHardwareSoftwareDTO.setDescription(task.getDescription());
        taskUserHardwareSoftwareDTO.setLogDate(task.getLogDate());
        taskUserHardwareSoftwareDTO.setPriority(task.getPriority());
        taskUserHardwareSoftwareDTO.setStatus(task.getStatus());
        taskUserHardwareSoftwareDTO.setTitle(task.getTitle());

        if(task.getHardware() != null) {
            taskUserHardwareSoftwareDTO.setSerialNumber(task.getHardware().getSerialNumber());
            taskUserHardwareSoftwareDTO.setHardwareName(task.getHardware().getName());
            taskUserHardwareSoftwareDTO.setHardwareProducerName(task.getHardware().getName());
        }

        if(task.getSoftware()!= null) {
            taskUserHardwareSoftwareDTO.setSoftwareProducerName(task.getSoftware().getName());
            taskUserHardwareSoftwareDTO.setSoftwareName(task.getSoftware().getName());
        }
        if(task.getUser() != null){
            taskUserHardwareSoftwareDTO.setUsername(task.getUser().getUsername());
        }
        return taskUserHardwareSoftwareDTO;
    }

}
