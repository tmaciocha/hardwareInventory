package pl.tm.hardwareinventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tm.hardwareinventory.model.Company;
import pl.tm.hardwareinventory.repository.CompanyRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {
    private final CompanyRepository companyRepository;

    //list
    @RequestMapping("/")
    public String list(Model model){
        model.addAttribute("companies", companyRepository.findAllByOrderByNameAsc());
        return "/companies/list";
    }

    //add
    @GetMapping ("/add")
    public String add(Model model){
        model.addAttribute("company", new Company());
        return "/companies/add";
    }

    //save new
    @PostMapping("/add")
    public String save(@Valid Company company, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/companies/add";
        }
        companyRepository.save(company);
        return "redirect:/company/";
    }

    //edit
    @GetMapping("/edit/{id}")
    public String edit (@PathVariable long id, Model model){
        Optional<Company> companyOptional = Optional.of(companyRepository.getById(id));
        if(companyOptional.isPresent()){
            model.addAttribute("company", companyOptional.get());
        }else {
            throw new RuntimeException() ;
        }
        return "companies/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid Company company, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "companies/edit";
        }
        companyRepository.save(company);
        return "redirect:/company/";
    }


}
