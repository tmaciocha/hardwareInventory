package pl.tm.hardwareinventory.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tm.hardwareinventory.dto.TaskUserHardwareSoftwareDTO;
import pl.tm.hardwareinventory.model.Hardware;
import pl.tm.hardwareinventory.model.Software;
import pl.tm.hardwareinventory.model.Task;
import pl.tm.hardwareinventory.repository.*;
import pl.tm.hardwareinventory.service.JpaTaskServiceImpl;
import pl.tm.hardwareinventory.service.TaskService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final SoftwareRepository softwareRepository;
    private final TaskService taskService;
    private final HardwareRepository hardwareRepository;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final JpaTaskServiceImpl jpaTaskService;

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);


    @GetMapping("/all-tasks")
    public String taskListDto(ModelMap model) {
        model.addAttribute("tasksDto", jpaTaskService.getAllTaskUserHardwareSoftware());
        return "tasks/list";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, ModelMap model) {
        Optional<Task> taskOptional = jpaTaskService.getTaskFromId(id);
        if (taskOptional.isPresent()) {
            model.addAttribute("taskDto", taskOptional.get());
        } else {
            throw new IllegalArgumentException();
        }
        return "tasks/edit";
    }

    @PostMapping("/edit")
    public String update(@RequestParam long id, @Valid TaskUserHardwareSoftwareDTO taskDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "tasks/edit";
        }
        Optional<Task> taskOptional = taskRepository.findById(id);
        if(taskOptional.isPresent()){

            Task taskToUpdate = taskOptional.get();
            taskToUpdate.setId(taskOptional.get().getId());
            taskToUpdate.setLogDate(taskOptional.get().getLogDate());
            if(taskToUpdate.getStatus() == false) {
                if (taskDto.getStatus() == true) {
                    taskToUpdate.setCloseDate(LocalDate.now());
                }
            }
            if(taskToUpdate.getStatus()){
                if(taskDto.getStatus() == false){
                    taskToUpdate.setCloseDate(null);
                    taskToUpdate.setLogDate(LocalDate.now());
                }
            }
            taskToUpdate.setDescription(taskDto.getDescription());
            taskToUpdate.setPriority(taskDto.getPriority());
            taskToUpdate.setStatus(taskDto.getStatus());
            taskToUpdate.setTitle(taskDto.getTitle());
            taskService.update(taskToUpdate);
        }
        return "redirect:/";
    }



    @GetMapping("/add/software/{softwareId}")
    public String addTask(Model model, @PathVariable long softwareId) {
        model.addAttribute("task", new Task());
        model.addAttribute("software", softwareRepository.findById(softwareId));
        return "tasks/add/software";
    }

    @PostMapping("/add/software/{softwareId}")
    public String saveSoftwareTask(@PathVariable long softwareId, @Valid Task task, BindingResult bindingResultTask) {
        if (bindingResultTask.hasErrors()) {
            return "tasks/add/software";
        }


        task.setStatus(false);
        task.setSoftware(softwareRepository.getById(softwareId));
        task.setLogDate(LocalDate.now());
        taskService.add(task);

        return "redirect:/";
    }

    @GetMapping("/add/hardware/{hardwareId}")
    public String addHardwareTask(Model model, @PathVariable long hardwareId) {
        model.addAttribute("task", new Task());
        model.addAttribute("hardware", hardwareRepository.findById(hardwareId));
        return "tasks/add/hardware";
    }

    @PostMapping("/add/hardware/{hardwareId}")
    public String saveHardwareTask(@PathVariable long hardwareId, @Valid Task task, BindingResult bindingResultTask) {
        if (bindingResultTask.hasErrors()) {
            return "tasks/add/software";
        }
        task.setStatus(false);
        task.setHardware(hardwareRepository.getById(hardwareId));
        task.setLogDate(LocalDate.now());
        taskService.add(task);
        return "redirect:/";
    }

    @GetMapping("/add/user/{userId}")
    public String addUserTask(Model model, @PathVariable long userId) {
        model.addAttribute("task", new Task());
        model.addAttribute("user", userRepository.findById(userId));
        return "tasks/add/user";
    }

    @PostMapping("/add/user/{userId}")
    public String saveUserTask(@PathVariable long userId, @Valid Task task, BindingResult bindingResultTask) {
        if (bindingResultTask.hasErrors()) {
            return "tasks/add/user";
        }
        task.setStatus(false);
        task.setUser(userRepository.getById(userId));
        task.setLogDate(LocalDate.now());
        taskService.add(task);
        return "redirect:/";
    }

}
