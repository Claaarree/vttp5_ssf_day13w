package sg.edu.nus.iss.vttp5a_ssf_day13w.model;

import java.io.File;
import java.util.Date;
import java.util.Random;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import sg.edu.nus.iss.vttp5a_ssf_day13w.utils.Utility;

public class Contact {
    private String id = "";
    private File contactFile = new File(Utility.dataDir + File.pathSeparator + id + ".txt");

    // when to use NotBlank, NotNull, NotEmpty?
    // NotBlank use for String variables
    // Everthing else use NotEmpty (covers null and empty)
    // If a collection let's say list can be empty but not null, use NotNull
    // If is Integer use MIN or MAX validation because default value for int is ZERO
    @NotEmpty(message = "Your name is required!")
    @Size(min = 3, max = 64, message = "Your name must be between 3 - 64 characters.")
    private String name;

    @NotEmpty(message = "Your email is required!")
    @Email(message = "Please enter a valid email!")
    private String email;

    @NotEmpty(message = "Your phone number is required!")
    @Size(min = 7, message = "Your phone number must be at least 7 digits.")
    private String phoneNumber;

    //how to validate date range?
    //used global error to validate!
    @Past(message = "Your date of birth is required!")
    @NotNull(message = "Your date of birth is required!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    
    //why does the auto generated constructor have the annotations?
    public Contact(String name, String email, String phoneNumber, Date dob) {
        Random rand = new Random();
        int randInt = rand.nextInt();
        this.id += Integer.toHexString(randInt);

        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public Contact() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public File getContactFile() {
        return contactFile;
    }

    public void setContactFile(File contactFile) {
        this.contactFile = contactFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }




    
}
