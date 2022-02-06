package pl.tm.hardwareinventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.tm.hardwareinventory.model.Invoice;
import pl.tm.hardwareinventory.model.MyFile;
import pl.tm.hardwareinventory.repository.CompanyRepository;
import pl.tm.hardwareinventory.repository.InvoiceRepository;
import pl.tm.hardwareinventory.repository.MyFileRepository;

import javax.persistence.Column;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/invoice")
public class InvoiceController {
    private final InvoiceRepository invoiceRepository;
    private final CompanyRepository companyRepository;
    private final MyFileRepository myFileRepository;
    private static final String UPLOAD_DIRECTORY ="/invoices";


    @GetMapping("/viewFile")
    public String testView(){
        return "invoices/viewFile";
    }






    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("invoices",invoiceRepository.findAll());
        model.addAttribute("myFiles",myFileRepository.findAll());
        model.addAttribute("myFiles",myFileRepository.findAll());
        return ("/invoices/list");
    }

    //ADD
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("invoice",new Invoice());
        model.addAttribute("companies",companyRepository.findAll());
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

    //EDIT
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model){
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
        if(invoiceOptional.isPresent()) {
            model.addAttribute("invoice", invoiceOptional.get());
            model.addAttribute("sellers", companyRepository.findAll());
        }else {
            throw new IllegalArgumentException();
        }
        return ("/invoices/edit");
    }

    @PostMapping("/edit")
    public String update (@Valid Invoice invoice, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ("/invoices/edit");
        }
        invoiceRepository.save(invoice);
        return "redirect:/invoice/";
    }



    @GetMapping("/file/{id}")
    public String uploadFile(Model model, @PathVariable long id){
        model.addAttribute("invoice", invoiceRepository.findById(id));
        return ("/invoices/file");
    }


   /* @RequestMapping("uploadform")
    public ModelAndView uploadForm(){
        return new ModelAndView("uploadform");
    }
*/
    @PostMapping("/savefile/{id}")
    //@RequestMapping(value="savefile",method=RequestMethod.POST)
    public ModelAndView saveimage(@PathVariable long id, @Valid Invoice invoice, BindingResult bindingResult, @RequestParam CommonsMultipartFile file,
                                   HttpSession session) throws Exception{
            if (bindingResult.hasErrors()){
                return new ModelAndView("/invoices/add");
            }




        ServletContext context = session.getServletContext();
        String path = context.getRealPath(UPLOAD_DIRECTORY);
        String filename = file.getOriginalFilename();

        //System.out.println(path+"/"+filename);

        byte[] bytes = file.getBytes();
        BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream( //pobieranie
                new File(path + File.separator + filename)));

        MyFile newFile = new MyFile();
        invoice.setFilename(filename);
        invoice.setPathFile(path+"/"+filename);
        invoiceRepository.save(invoice);
        newFile.setInvoice(invoice);
        newFile.setFilename(filename);
        newFile.setPathFile(path);
        myFileRepository.save(newFile);


        stream.write(bytes);
        stream.flush();
        stream.close();

        return new ModelAndView("redirect:/invoice/","filesuccess","File successfully saved!");
    }




}
