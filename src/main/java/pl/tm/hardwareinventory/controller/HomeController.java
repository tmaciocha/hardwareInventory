package pl.tm.hardwareinventory.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tm.hardwareinventory.model.User;
import pl.tm.hardwareinventory.repository.*;
import pl.tm.hardwareinventory.service.TaskService;
import pl.tm.hardwareinventory.service.UserService;

import java.time.LocalDateTime;
import java.util.Collections;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final HardwareRepository hardwareRepository;
    private final SoftwareRepository softwareRepository;
    private final TaskService taskService;
    private final TaskRepository taskRepository;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
                                    /*@RequestMapping("/sample-logger")
                                    @ResponseBody
                                    public String sample() {
                                    logger.info("simple log");
                                    int a = 2;
                                    int b = 5;
                                    logger.debug("a = {}, b = {} ", a, b);
                                    return "sample";
                                    }*/



    @GetMapping("/")
    public String homePage(Model model){
        logger.info("!!!!!!Welcome in Hardware Inventory App!!!!!!");
        if(userRepository.findByUsername("admin@gmail.com") == null){
            User user = new User();
            user.setUsername("admin@gmail.com");
            user.setPassword("pass");
            user.setFirstName("admin");
            user.setLastName("admin");
            user.setEndOfContract(null);
            user.setActiveUser(true);
            user.setSuperUser(true);
            user.setRoles(Collections.singleton(roleRepository.getById(2)));
            userService.saveUser(user);
            logger.info("!!!!!!Admin created: admin@gmail.com, pass!!!!!!");

        }
        model.addAttribute("tasks", taskRepository.findAllByOrderByPriorityDesc());
        model.addAttribute("tasksNumber", taskService.number());
        model.addAttribute("usersNumber", userRepository.findAll().stream().count());
        model.addAttribute("hardwareNumber", hardwareRepository.findAll().stream().count());
        model.addAttribute("softwareNumber", softwareRepository.findAll().stream().count());
        model.addAttribute("softwareList", softwareRepository.findAll());
        model.addAttribute("hardware",hardwareRepository.findAll());
        model.addAttribute("users",userRepository.findAll());
        return "index";
    }
}
