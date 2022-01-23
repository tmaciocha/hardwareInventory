package pl.tm.hardwareinventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.tm.hardwareinventory.model.User;
import pl.tm.hardwareinventory.repository.UserRepository;

import java.util.Collection;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;



    @GetMapping("/list")
    public String usersList(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "users/list";
    }

    @GetMapping("/remove/{id}")
    public String getRemoveForm(@PathVariable long id, Model model) {
        model.addAttribute("userId", id);
        return "users/delete";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model model, @RequestParam String confirm){
        if(confirm.equals("Yes")) {
            Optional<User> user = userRepository.findById(id);
            if(user.isPresent()&& !user.get().isSuperUser()) {
                userRepository.deleteById(id);
                model.addAttribute("userId", null);
            }
        }
        return "redirect:/user/list";
    }


}
