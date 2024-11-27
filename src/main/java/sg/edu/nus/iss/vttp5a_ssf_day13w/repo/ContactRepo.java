package sg.edu.nus.iss.vttp5a_ssf_day13w.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_ssf_day13w.model.Contact;

@Repository
public class ContactRepo {

    @Autowired
    private RedisTemplate<String, Contact> template;
    private String redisKey = "persons";
    
    private List<Contact> persons = new ArrayList<>();

    public List<Contact> getAllContacts(){
        return template.opsForList().range(redisKey, 0, -1);
        // return persons;
    }

    public void createContact(Contact p) {
        template.opsForList().rightPush(redisKey, p);
        // persons.add(p);
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
