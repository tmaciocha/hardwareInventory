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
import pl.tm.hardwareinventory.repository.RoleRepository;
import pl.tm.hardwareinventory.repository.UserRepository;
import pl.tm.hardwareinventory.service.UserService;

import java.time.LocalDateTime;
import java.util.Collections;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;
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
            logger.info("!!!!!!Admin created!!!!!!");
            return "index";
        }
        return "index";
    }
}
