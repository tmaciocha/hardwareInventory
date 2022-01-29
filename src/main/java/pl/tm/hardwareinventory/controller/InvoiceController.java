package pl.tm.hardwareinventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tm.hardwareinventory.model.Company;
import pl.tm.hardwareinventory.model.Invoice;
import pl.tm.hardwareinventory.repository.CompanyRepository;
import pl.tm.hardwareinventory.repository.InvoiceRepository;

import javax.persistence.Column;
import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequiredArgsConstructor
@RequestMapping("/invoice")
public class InvoiceController {
    private final InvoiceRepository invoiceRepository;
    private final CompanyRepository companyRepository;

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("invoices",invoiceRepository.findAll());
      //  model.addAttribute("company", companyRepository.findAll());
        return ("/invoices/list");
    }

    //ADD
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("invoice",new Invoice());
        return ("/invoices/add");
    }
    //SAVE
    @PostMapping("/add")
    public String save(@Valid Invoice invoice, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ("/invoices/add");
        }
        invoiceRepository.save(invoice);
        return "redirect:/invoice/";
    }

    @ModelAttribute("companies")
    public Collection<Company> companies(){
        return companyRepository.findAll();
    }

}
