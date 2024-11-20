package sg.edu.nus.iss.vttp5a_ssf_day13w.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.vttp5a_ssf_day13w.model.Person;
import sg.edu.nus.iss.vttp5a_ssf_day13w.service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
    
    @Autowired
    PersonService personService;

    @GetMapping()
    public String getAllPersons(Model model){
        List<Person> persons = personService.getAllPersons();
        model.addAttribute("persons", persons);

        return "contactList";
    }

    @GetMapping("/contact")
    public String getContactForm(Model model){
        Person p = new Person();
        model.addAttribute("person", p);

        return "contactForm";
    }

    @PostMapping("/contact")
    public String handleContactForm(@Valid @ModelAttribute("person") Person person, BindingResult result,
    Model model){
        if(result.hasErrors()){
            return "contactForm";
        }

        Person p = new Person(person.getName(), person.getEmail(), person.getPhoneNumber(), person.getDob());
        personService.createContact(p);

        return "redirect:/persons";
    }
}
