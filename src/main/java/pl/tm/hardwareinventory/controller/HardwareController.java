package pl.tm.hardwareinventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tm.hardwareinventory.model.Hardware;
import pl.tm.hardwareinventory.model.HardwareType;
import pl.tm.hardwareinventory.repository.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hardware")
public class HardwareController {
    private final HardwareRepository hardwareRepository;
    private final ProducerRepository producerRepository;
    private final HardwareTypeRepository hardwareTypeRepository;
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final InvoiceRepository invoiceRepository;
    private final HardwareQualityRepository hardwareQualityRepository;
    private final SoftwareRepository softwareRepository;

    @GetMapping("/")
    private String list(Model model){
        model.addAttribute("hardwareList", hardwareRepository.findAll());
        return "/hardware/list";
    }

    @GetMapping("/add")
    private String add( Model model){
        model.addAttribute("hardware", new Hardware());
        model.addAttribute("producers", producerRepository.findAllByOrderByNameAsc());
        model.addAttribute("hardwareTypes", hardwareTypeRepository.findAllByOrderByTypeAsc());
        model.addAttribute("companies", companyRepository.findAllByOrderByNameAsc());
        model.addAttribute("user", userRepository.findAll());
        model.addAttribute("invoices", invoiceRepository.findAll());
        model.addAttribute("qualities", hardwareQualityRepository.findAll());
        model.addAttribute("softwareList", softwareRepository.findAll());
        return "/hardware/add";
    }

    @PostMapping("/add")
    private String save(@Valid Hardware hardware, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/hardware/add";
        }
        hardware.setLastChangeDate(LocalDate.now());
        hardware.setInUse(true);
        hardware.setUsable(true);
        hardwareRepository.save(hardware);


        hardware.getSoftwareList().forEach(s -> {
            s.getHardwareList().add(hardware);
            softwareRepository.save(s);
        });



        return "redirect:/hardware/";
    }



    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable long id, Model model) {
        Optional<Hardware> hardware = hardwareRepository.findById(id);
        if (hardware.isPresent()) {
            model.addAttribute("hardware", hardware.get());
            model.addAttribute("producers", producerRepository.findAllByOrderByNameAsc());
            model.addAttribute("hardwareTypes", hardwareTypeRepository.findAllByOrderByTypeAsc());
            model.addAttribute("companies", companyRepository.findAllByOrderByNameAsc());
            model.addAttribute("user", userRepository.findAll());
            model.addAttribute("invoices", invoiceRepository.findAll());
            model.addAttribute("qualities", hardwareQualityRepository.findAll());
            model.addAttribute("softwareList", softwareRepository.findAll());
        } else {
            throw new RuntimeException();
        }
        return "hardware/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid Hardware hardware, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "hardware/edit";
        }
        hardware.setLastChangeDate(LocalDate.now());
        hardwareRepository.save(hardware);
        return "redirect:/hardware/";
    }


    @GetMapping("/details/{id}")
    public String details(@PathVariable long id, Model model) {
        Optional<Hardware> hardware = hardwareRepository.findById(id);
        if (hardware.isPresent()) {
            model.addAttribute("hardware", hardware.get());
        } else {
            throw new RuntimeException();
        }
        return "hardware/details";
    }
}
