package pl.tm.hardwareinventory.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tm.hardwareinventory.model.Hardware;
import pl.tm.hardwareinventory.model.Software;
import pl.tm.hardwareinventory.model.User;
import pl.tm.hardwareinventory.repository.*;

import javax.validation.Valid;
import java.time.LocalDate;
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
    private String saveSoftware(@Valid Software software, BindingResult bindingResult, Model model) {
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
            model.addAttribute("companies", companyRepository.findAll());
            model.addAttribute("users", userRepository.findAll());
            model.addAttribute("hardwareList", hardwareRepository.findAll());
        } else {
            throw new IllegalArgumentException();
        }
        return "software/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid Software software, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "software/edit";
        }

        softwareRepository.save(software);

        software.getUsers().forEach(u->{
            u.getSoftwareList().clear();
            u.getSoftwareList().add(software);
            userRepository.save(u);
        });



        return "redirect:/software/";
    }




        /*
        Map<String, List<Software>> softwareMap = new HashMap<>();
    software.getUsers().forEach(u -> u.setSoftwareList(software));
        software.getUsers().forEach(u -> {
            softwareMap.put(u.getUsername(), u.getSoftwareList());
        });

        software.getUsers().forEach(u -> u.getSoftwareList().clear());// (emptyList));
*/      //software.getUsers().clear();

        /*Software software1 = software;
        software.getUsers().forEach(u -> {
            u.getSoftwareList().clear();
            userRepository.save(u);
        });
*/
    /*      softwareRepository.save(software);
     */

/*


       software.getUsers().forEach(u -> {
                    for (Map.Entry<String, List<Software>> entry : softwareMap.entrySet()) { //jest lista softu
                        logger.info(u.getUsername() + "!!!!!!!!!!!!u.getUsername()!!!!!!!!!!!!!!!!!!");
                        logger.info(entry.getValue().toString() +"!!!!!!!!!!!!!!!!entry.getValue().toString()!!!!!!!!!!!!1" );
                        if (u.getUsername().equals(entry.getKey())) {
                            u.setSoftwareList(entry.getValue());

                            userRepository.save(u);
                            logger.info(u.getSoftwareList().toString() + "!!!!!!!u.getSoftwareList().!!!!!!!!!!!!!!!!!!!!!!!");
                        }
                    }
                }
        );
        software.setLogDate(LocalDate.now());
        softwareRepository.save(software);
*/


    @GetMapping("/details/{id}")
    public String details(@PathVariable long id, Model model) {
        Optional<Software> software = softwareRepository.findById(id);
        if (software.isPresent()) {
            model.addAttribute("software", software.get());
        } else {
            throw new RuntimeException();
        }
        return "software/details";
    }


}
