package sg.edu.nus.iss.vttp5a_ssf_day13w.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_ssf_day13w.model.Contact;

@Repository
public class ContactRepo {
    
    private List<Contact> persons = new ArrayList<>();

    public List<Contact> getAllContacts(){
        return persons;
    }

    public void createContact(Contact p) {
        persons.add(p);
    }

    public Contact findById(String id) {
        Contact foundContact = null;
        for (Contact p : persons){
            if (p.getId().equals(id)){
                foundContact = p;
            }
        }
        return foundContact;
    }


}
