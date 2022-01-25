package pl.tm.hardwareinventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tm.hardwareinventory.model.SoftwareType;
import pl.tm.hardwareinventory.model.User;
import pl.tm.hardwareinventory.repository.SoftwareTypeRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/softwaretype")
public class SoftwareTypeController {
        private final SoftwareTypeRepository softwareTypeRepository;

        @GetMapping("/")
        private String list(Model model){
            model.addAttribute("softwareTypes", softwareTypeRepository.findAllByOrderByTypeAsc());
            return "/admin/settings/softwareType/list";
        }

        @GetMapping("/add")
    private String add( Model model){
        model.addAttribute("softwaretype", new SoftwareType());
        return "/admin/settings/softwareType/add";
        }

    @PostMapping("/add")
    private String save(@Valid SoftwareType softwareType, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "admin/settings/softwareType/add";
        }
            softwareTypeRepository.save(softwareType);
        return "redirect:/softwaretype/";
    }



    @GetMapping("/remove/{id}")
    public String getRemoveForm(@PathVariable long id, Model model) {
        model.addAttribute("softwaretypeId", id);
        return "admin/settings/softwareType/delete";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model model, @RequestParam String confirm) {
        if (confirm.equals("Yes")) {
            Optional<SoftwareType> softwareType = softwareTypeRepository.findById(id);
            if (softwareType.isPresent()) {
                softwareTypeRepository.deleteById(id);
                model.addAttribute("softwaretypeId", null);
            }
        }
        return "redirect:/softwaretype/";
    }



    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable long id, Model model) {
        Optional<SoftwareType> softwareType = softwareTypeRepository.findById(id);
        if (softwareType.isPresent()) {
            model.addAttribute("softwaretype", softwareType.get());
        } else {
            throw new RuntimeException();
        }
        return "admin/settings/softwareType/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid SoftwareType softwareType, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/settings/softwareType/edit";
        }
        softwareTypeRepository.save(softwareType);
        return "redirect:/softwaretype/";
    }
}
