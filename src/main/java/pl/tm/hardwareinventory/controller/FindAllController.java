package pl.tm.hardwareinventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.tm.hardwareinventory.model.User;
import pl.tm.hardwareinventory.repository.FindRepository;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/find")
public class FindAllController {
    private final FindRepository findRepository;

    @GetMapping("/all")
    @ResponseBody
    public String findAll(@RequestParam String search){
        Optional<User> user = findRepository.findFirstByFirstName(search);
        return user.toString();
    }

}
