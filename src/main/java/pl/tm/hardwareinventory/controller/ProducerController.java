package pl.tm.hardwareinventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tm.hardwareinventory.model.Producer;
import pl.tm.hardwareinventory.repository.ProducerRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerRepository producerRepository;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("producers", producerRepository.findAllByOrderByNameAsc());
        return "/admin/settings/producers/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("producer", new Producer());
        return "/admin/settings/producers/add";
    }

    @PostMapping("/add")
    public String save(@Valid Producer producer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/settings/producers/add";
        }
        producerRepository.save(producer);
        return "redirect:/producer/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Optional<Producer> producerOptional = producerRepository.findById(id);
        if (producerOptional.isPresent()) {
            model.addAttribute("producer", producerOptional.get());
        } else {
            throw new RuntimeException();
        }
        return "admin/settings/producers/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid Producer producer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/settings/producers/edit";
        }
        producerRepository.save(producer);
        return "redirect:/producer/";
    }

    @GetMapping("/remove/{id}")
    public String removeForm(@PathVariable long id, Model model) {
        model.addAttribute("producerId", id);
        return "admin/settings/producers/delete";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model model, @RequestParam String confirm) {
        if (confirm.equals("Yes")) {
            Optional<Producer> producer = producerRepository.findById(id);
            if (producer.isPresent()) {
                producerRepository.deleteById(id);
                model.addAttribute("producerId", null);
            }
        }
        return "redirect:/producer/";
    }
}
