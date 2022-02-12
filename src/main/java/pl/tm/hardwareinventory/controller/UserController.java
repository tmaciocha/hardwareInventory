package pl.tm.hardwareinventory.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tm.hardwareinventory.model.User;
import pl.tm.hardwareinventory.repository.RoleRepository;
import pl.tm.hardwareinventory.repository.UserRepository;
import pl.tm.hardwareinventory.service.UserService;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Collections;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @GetMapping("/")
    public String usersList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users/list";
    }

    @GetMapping("/remove/{id}")
    public String getRemoveForm(@PathVariable long id, Model model) {
        model.addAttribute("userId", id);
        if(id == 1){
            return "users/deleteAdmin";
        }
        return "users/delete";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model model, @RequestParam String confirm) {
        if (confirm.equals("Yes")) {
            Optional<User> user = userRepository.findById(id);
            if (user.isPresent() && !user.get().isSuperUser()) {
                userRepository.deleteById(id);
                model.addAttribute("userId", null);
            }
        }
        return "redirect:/user/";
    }


    @GetMapping("/createAdmin")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin@gmail.com");
        user.setPassword("admin");
        user.setFirstName("adminFirstName");
        user.setLastName("adminLastName");
        user.setEndOfContract(null);
        user.setActiveUser(true);
        user.setSuperUser(true);
        user.setRoles(Collections.singleton(roleRepository.getById(2)));
        user.setPhoneNumber("2131232 123 13");
        userService.saveUser(user);
        return "admin";
    }


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "/users/add";
    }

    @PostMapping("/add")
    public String save(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/users/add";
        }
        userService.saveUser(user);
        return ("redirect:/user/");
    }


    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable long id, Model model) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userOptional.get().setPassword(null);
            model.addAttribute("user", userOptional.get());
        } else {
            throw new RuntimeException();
        }
        return "users/edit";
    }

    @PostMapping("/edit")
    public String updateUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        if(user.getId() == 1){
            user.setSuperUser(true);
            user.setActiveUser(true);

        }
        userService.saveUser(user);
        return "redirect:/user/";
    }

}
