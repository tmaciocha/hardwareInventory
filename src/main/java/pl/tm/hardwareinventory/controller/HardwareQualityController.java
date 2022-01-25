package pl.tm.hardwareinventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tm.hardwareinventory.model.HardwareQuality;
import pl.tm.hardwareinventory.repository.HardwareQualityRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hardwareQuality")
public class HardwareQualityController {
        private final HardwareQualityRepository hardwareQRepo;

        @GetMapping("/")
        private String list(Model model){
            model.addAttribute("qualities", hardwareQRepo.findAllByOrderByNameAsc());
            return "/admin/settings/hardwareQuality/list";
        }

        @GetMapping("/add")
         private String add( Model model){
        model.addAttribute("qualityType", new HardwareQuality());
        return "/admin/settings/hardwareQuality/add";
        }

    @PostMapping("/add")
    private String save(@Valid HardwareQuality hardwareQuality, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/admin/settings/hardwareQuality/add";
        }
        hardwareQRepo.save(hardwareQuality);
        return "redirect:/hardwareQuality/";
    }



    @GetMapping("/remove/{id}")
    public String getRemoveForm(@PathVariable long id, Model model) {
        model.addAttribute("hardwareQID", id);
        return "admin/settings/hardwareQuality/delete";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model model, @RequestParam String confirm) {
        if (confirm.equals("Yes")) {
            Optional<HardwareQuality> hardwareQuality = hardwareQRepo.findById(id);
            if (hardwareQuality.isPresent()) {
                hardwareQRepo.deleteById(id);
                model.addAttribute("hardwareQID", null);
            }
        }
        return "redirect:/hardwareQuality/";
    }



    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable long id, Model model) {
        Optional<HardwareQuality> hardwareQuality = hardwareQRepo.findById(id);
        if (hardwareQuality.isPresent()) {
            model.addAttribute("hardwareQuality", hardwareQuality.get());
        } else {
            throw new RuntimeException();
        }
        return "admin/settings/hardwareQuality/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid HardwareQuality hardwareQuality, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/settings/hardwareQuality/edit";
        }
        hardwareQRepo.save(hardwareQuality);
        return "redirect:/hardwareQuality/";
    }
}
