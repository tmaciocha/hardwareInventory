package pl.tm.hardwareinventory.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.tm.hardwareinventory.model.Hardware;
import pl.tm.hardwareinventory.model.Software;
import pl.tm.hardwareinventory.model.User;
import pl.tm.hardwareinventory.repository.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;

@Controller
@RequiredArgsConstructor
@RequestMapping("/software")
public class SoftwareController {
    private final HardwareRepository hardwareRepository;
    private final ProducerRepository producerRepository;
    private final SoftwareTypeRepository softwareTypeRepository;
    private final SoftwareRepository softwareRepository;
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final InvoiceRepository invoiceRepository;

    private static final Logger logger = LoggerFactory.getLogger(SoftwareController.class);

    @GetMapping("/")
    private String list(Model model) {
        model.addAttribute("softwareList", softwareRepository.findAll());
        return "/software/list";
    }

    @GetMapping("/add")
    private String add(Model model) {
        model.addAttribute("software", new Software());
        model.addAttribute("producers", producerRepository.findAllByOrderByNameAsc());
        model.addAttribute("softwareTypes", softwareTypeRepository.findAllByOrderByTypeAsc());
        model.addAttribute("companies", companyRepository.findAllByOrderByNameAsc());
        model.addAttribute("userList", userRepository.findAll());
        model.addAttribute("invoices", invoiceRepository.findAll());
        model.addAttribute("hardwareList", hardwareRepository.findAll());
        return "software/add";
    }

    @PostMapping("/add")
    private String saveSoftware(@Valid Software software, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "software/add";
        }
        software.setLogDate(LocalDate.now());
        softwareRepository.save(software);

        software.getUsers().forEach(u -> {
            u.getSoftwareList().add(software);
            userRepository.save(u);
        });
        software.getHardwareList().forEach(h -> {
            h.getSoftwareList().add(software);
            hardwareRepository.save(h);
        });

        return "redirect:/software/";
    }


    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable long id, Model model) {
        Optional<Software> software = softwareRepository.findById(id);
        if (software.isPresent()) {
            model.addAttribute("software", software.get());
            model.addAttribute("hardwareList", hardwareRepository.findAll());
            model.addAttribute("producers", producerRepository.findAllByOrderByNameAsc());
            model.addAttribute("softwareTypes", softwareTypeRepository.findAllByOrderByTypeAsc());
            model.addAttribute("companies", companyRepository.findAllByOrderByNameAsc());
            model.addAttribute("users", userRepository.findAll());
            model.addAttribute("invoices", invoiceRepository.findAll());
        } else {
            throw new IllegalArgumentException();
        }
        return "software/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid Software software, BindingResult bindingResult, @RequestParam long id) {
        if (bindingResult.hasErrors()) {
            return "software/edit";
        }
        software.setLogDate(LocalDate.now());
        softwareRepository.save(software);

        //users list editing
        userRepository.findAll().forEach(u -> {
            List<Software> softwareList = u.getSoftwareList();
            softwareList.removeIf(software1 -> software1.getId() == software.getId());
            userRepository.save(u);
        });

        software.getUsers().forEach(u -> {
            u.getSoftwareList().add(software);
            userRepository.save(u);
        });


        //hardware list editing
        hardwareRepository.findAll().forEach(h -> {
            List<Software> softwareList = h.getSoftwareList();
            softwareList.removeIf(software1 -> software1.getId() == software.getId());
            hardwareRepository.save(h);
        });
        software.getHardwareList().forEach(h->{
            h.getSoftwareList().add(software);
            hardwareRepository.save(h);
        });

        return "redirect:/software/";
    }




    @GetMapping("/details/{id}")
    public String details(@PathVariable long id, Model model) {
        Optional<Software> software = softwareRepository.findById(id);
        if (software.isPresent()) {
            model.addAttribute("software", software.get());
            model.addAttribute("users", userRepository.findAll());
        } else {
            throw new RuntimeException();
        }
        return "software/details";
    }

}
