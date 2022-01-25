package pl.tm.hardwareinventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tm.hardwareinventory.repository.SoftwareTypeRepository;

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


}
