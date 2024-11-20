package sg.edu.nus.iss.vttp5a_ssf_day13w.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_ssf_day13w.model.Person;
import sg.edu.nus.iss.vttp5a_ssf_day13w.repo.PersonRepo;

@Service
public class PersonService {
    
    @Autowired
    PersonRepo personRepo;

    public List<Person> getAllPersons(){
        return personRepo.getAllPersons();
    }

    public void createContact(Person p) {
        personRepo.createContact(p);
    }
}
