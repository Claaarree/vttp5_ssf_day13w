package sg.edu.nus.iss.vttp5a_ssf_day13w.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_ssf_day13w.model.Person;

@Repository
public class PersonRepo {
    
    private List<Person> persons = new ArrayList<>();

    public List<Person> getAllPersons(){
        return persons;
    }

    public void createContact(Person p) {
        persons.add(p);
    }
}
