package com.example.mycontact.controller;

import com.example.mycontact.entity.Contact;
import com.example.mycontact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.StringUtils;

import javax.validation.Valid;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public String list(Model model){
        model.addAttribute("contact", contactService.findAll());
        return "list";
    }

    @GetMapping("/contact/search")
    public String search(@RequestParam("term") String term, Model model){
        if(StringUtils.isEmpty(term)){
            return "redirect:/contact";
        }

        model.addAttribute("contacts",contactService.search(term));

        return "list";
    }

    @GetMapping("/contact/add")
    public String add(Model model){
        model.addAttribute("contact",new Contact());
        return "form";
    }

    @PostMapping("/contact/save")
    public String save(@Valid Contact contact, BindingResult result, RedirectAttributes redirect){
        if(result.hasErrors()){
            return "form";
        }
        contactService.save(contact);
        redirect.addFlashAttribute("successMessage", "Saved contact successfully!");
        return "redirect:/contact";
    }



}
