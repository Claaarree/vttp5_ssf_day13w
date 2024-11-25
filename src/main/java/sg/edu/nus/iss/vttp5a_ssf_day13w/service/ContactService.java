package sg.edu.nus.iss.vttp5a_ssf_day13w.service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_ssf_day13w.model.Contact;
import sg.edu.nus.iss.vttp5a_ssf_day13w.repo.ContactRepo;
import sg.edu.nus.iss.vttp5a_ssf_day13w.utils.Utility;

@Service
public class ContactService {
    
    @Autowired
    ContactRepo contactRepo;

    public List<Contact> getAllContacts(){
        return contactRepo.getAllContacts();
    }

    public void createContact(Contact p) {
        Utility.writeToFile(p);
        contactRepo.createContact(p);
    }

    public Boolean isDobValid(Date dob){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dobString = sdf.format(dob);
        int dobYear = Integer.parseInt(dobString.split("-")[0]);
        int dobMonth = Integer.parseInt(dobString.split("-")[1]);
        int dobDay = Integer.parseInt(dobString.split("-")[2]);
        
        Date currentDate = Date.from(Instant.now());
        String currDateString = sdf.format(currentDate);
        int currYear = Integer.parseInt(currDateString.split("-")[0]);
        int currMonth = Integer.parseInt(currDateString.split("-")[1]);
        int currDay = Integer.parseInt(currDateString.split("-")[2]);


        int age = currYear - dobYear;
        if (currMonth < dobMonth){
            age--;
        } else if(currMonth == dobMonth){
            if (currDay < dobDay){
                age--;
            }
        }

        if (age < 10 || age > 100){
            return false;
        } else return true;
    }

    public List<String> getContactData(String id) {
        Contact foundContact = contactRepo.findById(id);
        List<String> dataRead = Utility.readContactFile(foundContact);

        return dataRead;
    }
}
