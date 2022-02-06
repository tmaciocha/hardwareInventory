package pl.tm.hardwareinventory.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tm.hardwareinventory.model.Software;
import pl.tm.hardwareinventory.model.Task;
import pl.tm.hardwareinventory.repository.*;
import pl.tm.hardwareinventory.service.TaskService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final SoftwareRepository softwareRepository;
    private final TaskService taskService;
    private final HardwareRepository hardwareRepository;
    private final UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);


    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks/list";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model){
        Optional<Task> taskOptional = taskService.getTaskFromId(id);
        if(taskOptional.isPresent()) {
            int taskStatusInt=0;
            if(taskOptional.get().getStatus()){
                taskStatusInt = 1;
            };
            model.addAttribute("task", taskOptional.get());
            model.addAttribute("taskStatusInt", taskStatusInt);
        }else {
            throw new IllegalArgumentException();
        }
        return "tasks/edit";
    }

    @PostMapping("/edit/{taskStatusInt}")
    public String update(@PathVariable int taskStatusInt, @Valid Task task, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "tasks/edit";
        }
        Boolean historicalStatus=false;
        if(taskStatusInt == 1){
            logger.info(taskStatusInt + " !!!=!!!taskStatusInt ");
            historicalStatus=true;
        }

        if( historicalStatus == task.getStatus()){
            if(task.getStatus()) {
                task.setCloseDate(LocalDate.now());
                logger.info(task.getCloseDate() + " !!!1=!!!task.getCloseDate()");
                logger.info(task.getLogDate() + " !!!2=!!!task.getLogDate()");
            }else{
                task.setCloseDate(null);
                task.setLogDate(LocalDate.now());
                logger.info(task.getCloseDate() + " !!!3=!!!task.getCloseDate()");
                logger.info(task.getLogDate() + " !!!4=!!!task.getLogDate()");
        }

        }
        taskService.update(task);
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
