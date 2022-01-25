package pl.tm.hardwareinventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tm.hardwareinventory.model.HardwareQuality;
import pl.tm.hardwareinventory.model.HardwareType;
import pl.tm.hardwareinventory.repository.HardwareTypeRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hardwareType")
public class HardwareTypeController {
    private final HardwareTypeRepository hardwareTRepo;

    @GetMapping("/")
    private String list(Model model){
        model.addAttribute("hardwareTypes", hardwareTRepo.findAllByOrderByTypeAsc());
        return "/admin/settings/hardwareType/list";
    }

    @GetMapping("/add")
    private String add( Model model){
        model.addAttribute("hardwareType", new HardwareType());
        return "/admin/settings/hardwareType/add";
    }

    @PostMapping("/add")
    private String save(@Valid HardwareType hardwareType, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/admin/settings/hardwareType/add";
        }
        hardwareTRepo.save(hardwareType);
        return "redirect:/hardwareType/";
    }


    @GetMapping("/remove/{id}")
    public String getRemoveForm(@PathVariable long id, Model model) {
        model.addAttribute("hardwareTID", id);
        return "admin/settings/hardwareType/delete";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model model, @RequestParam String confirm) {
        if (confirm.equals("Yes")) {
            Optional<HardwareType> hardwareType = hardwareTRepo.findById(id);
            if (hardwareType.isPresent()) {
                hardwareTRepo.deleteById(id);
                model.addAttribute("hardwareTID", null);
            }
        }
        return "redirect:/hardwareType/";
    }



    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable long id, Model model) {
        Optional<HardwareType> hardwareType = hardwareTRepo.findById(id);
        if (hardwareType.isPresent()) {
            model.addAttribute("hardwareType", hardwareType.get());
        } else {
            throw new RuntimeException();
        }
        return "admin/settings/hardwareType/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid HardwareType hardwareType, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/settings/hardwareType/edit";
        }
        hardwareTRepo.save(hardwareType);
        return "redirect:/hardwareType/";
    }
}
