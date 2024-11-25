package sg.edu.nus.iss.vttp5a_ssf_day13w.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.vttp5a_ssf_day13w.model.Contact;
import sg.edu.nus.iss.vttp5a_ssf_day13w.service.ContactService;

@Controller
@RequestMapping("/persons")
public class ContactController {
    
    @Autowired
    ContactService contactService;

    @GetMapping()
    public String getAllPersons(Model model){
        List<Contact> persons = contactService.getAllContacts();
        model.addAttribute("persons", persons);

        return "contactList";
    }

    @GetMapping("/contact/{id}")
    public String getByID(@PathVariable String id, Model model){
        List<String> dataRead = contactService.getContactData(id);
        model.addAttribute("dataRead", dataRead);

        return "individualContact";
    }

    @GetMapping("/contact")
    public String getContactForm(Model model){
        Contact p = new Contact();
        model.addAttribute("person", p);

        return "contactForm";
    }

    @PostMapping("/contact")
    public String handleContactForm(@Valid @ModelAttribute("person") Contact person, BindingResult result,
    Model model){
        if(result.hasErrors()){
            return "contactForm";
        }

        if (!contactService.isDobValid(person.getDob())){
            ObjectError err = new ObjectError("ageError",
            "Your age doesn't allow you to be added as a contact.");
            result.addError(err);
            return "contactForm";
        }

        Contact p = new Contact(person.getName(), person.getEmail(), person.getPhoneNumber(), person.getDob());
        contactService.createContact(p);

        
        return "redirect:/persons";
    }
}
