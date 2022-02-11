package pl.tm.hardwareinventory.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.tm.hardwareinventory.model.Task;
import pl.tm.hardwareinventory.model.User;
import pl.tm.hardwareinventory.repository.*;
import pl.tm.hardwareinventory.service.JpaTaskServiceImpl;
import pl.tm.hardwareinventory.service.TaskService;
import pl.tm.hardwareinventory.service.UserService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final HardwareRepository hardwareRepository;
    private final SoftwareRepository softwareRepository;
    private final JpaTaskServiceImpl jpaTaskService;
    private final TaskRepository taskRepository;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


    @GetMapping("/")
    public String homePage(Model model, ModelMap modelMap) {
        logger.info("!!!!!!Welcome in Hardware Inventory App!!!!!!");
        if (userRepository.findByUsername("admin@gmail.com") == null) {
            User user = new User();
            user.setUsername("admin@gmail.com");
            user.setPassword("pass");
            user.setFirstName("admin");
            user.setLastName("admin");
            user.setEndOfContract(null);
            user.setActiveUser(true);
            user.setSuperUser(true);
            user.setRole(roleRepository.getById(2));
            userService.saveUser(user);
            logger.info("!!!!!!Admin created: admin@gmail.com, pass!!!!!!");

        }
        modelMap.addAttribute("tasksDto", jpaTaskService.getAllTaskUserHardwareSoftwareStatusFalse());
        model.addAttribute("tasksNumber", jpaTaskService.numberActiveTask());
        model.addAttribute("users3MonthsEnd", userRepository.activeUserNumberWhereContractEndInThreeMonth());
        model.addAttribute("usersWithEndedContract", userRepository.usersWhichContractHasEnded());
        model.addAttribute("usersNumber", userRepository.findAll().stream().count());
        model.addAttribute("hardwareNumber", hardwareRepository.findAll().stream().count());
        model.addAttribute("softwareNumber", softwareRepository.findAll().stream().count());
        model.addAttribute("softwareList", softwareRepository.findAll());
        model.addAttribute("hardware", hardwareRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("done", false);
        return "index";
    }


    @PostMapping("/search")
    public String find(@RequestParam String search, Model model) {
        model.addAttribute("search", search);
        /*if(search.contains("@")){
            User user = userRepository.findByUsername(search);
            List<Hardware> hardwareList = hardwareRepository.findAllByUserId(user.getId());
            model.addAttribute("hardwareSearch", hardwareList);
            return "hardware/find";
        }*/
        List<Task> taskList = taskRepository.findAllByTitleOOrderByDescription(search);
        if (taskList.size() > 0) {
            model.addAttribute("taskSearch", taskList);
            return "/findDashboard";
        }
        return "redirect:/";
    }

    @PostMapping("/")
    public String filterDone(@RequestParam Boolean done, Model model, ModelMap modelMap){
        Optional<Boolean> doneOptional = Optional.ofNullable(done);
        if(doneOptional.isPresent() && done){
            modelMap.addAttribute("tasksDto", jpaTaskService.getAllTaskUserHardwareSoftware());
            model.addAttribute("tasksNumber", jpaTaskService.numberActiveTask());
            model.addAttribute("users3MonthsEnd", userRepository.activeUserNumberWhereContractEndInThreeMonth());
            model.addAttribute("usersWithEndedContract", userRepository.usersWhichContractHasEnded());
            model.addAttribute("usersNumber", userRepository.findAll().stream().count());
            model.addAttribute("hardwareNumber", hardwareRepository.findAll().stream().count());
            model.addAttribute("softwareNumber", softwareRepository.findAll().stream().count());
            model.addAttribute("softwareList", softwareRepository.findAll());
            model.addAttribute("hardware", hardwareRepository.findAll());
            model.addAttribute("users", userRepository.findAll());
          //  model.addAttribute("done",true);
            return "index";
        }
        modelMap.addAttribute("tasksDto", jpaTaskService.getAllTaskUserHardwareSoftwareStatusFalse());
        model.addAttribute("tasksNumber", jpaTaskService.numberActiveTask());
        model.addAttribute("users3MonthsEnd", userRepository.activeUserNumberWhereContractEndInThreeMonth());
        model.addAttribute("usersWithEndedContract", userRepository.usersWhichContractHasEnded());
        model.addAttribute("usersNumber", userRepository.findAll().stream().count());
        model.addAttribute("hardwareNumber", hardwareRepository.findAll().stream().count());
        model.addAttribute("softwareNumber", softwareRepository.findAll().stream().count());
        model.addAttribute("softwareList", softwareRepository.findAll());
        model.addAttribute("hardware", hardwareRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
       // model.addAttribute("done",false);
        return "redirect:/";
    }
}

