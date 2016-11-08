/**
 * TEI of Athens, Department of Informatics
 * Master of Science in Computing and Network Technologies
 * Distributed Web Applications, Task 1 Ενδεικτική λύση, 
 * Subject: Πληροφοριακό Σύστημα Βιβλιοθήκης (Βιβλία, Φοιτητές,
 * Διαφορετικές καταστάσεις σε βιβλία -διαθέσιμο ή όχι, τοποθεσίες βιβλίων).
 * @author Michael Galliakis AM: CNT16003.
 * Ημερομηνία : 1/11/2016
 */
package kdt.task1.library;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import kdt.task1.global.*;

/**
 * Κλάση που έχει γενικά στοιχεία ενός ατόμου, με σκοπό να κληρονομηθεί
 * από τις κλάσεις Student, Professor και Staff.
 */
public class Person {
    static private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    private String username ;
    private String name ;
    private String surname ;
    private ArrayList<String> alEmail ;
    private String address ;
    private Date dateOfBirth ;
    private ArrayList<CopyBook> alCBooks ; // Βιβλία που έχει δανειστεί
    
    public Person(String username, String name, String surname) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        alEmail = new ArrayList<>();
        alCBooks = new ArrayList<>() ;
        dateOfBirth = new Date();
    }
    
    public Person(String username, String name, String surname, ArrayList<String> alEmail, String address, Date dateOfBirth) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.alEmail = alEmail;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        alCBooks = new ArrayList<>() ;
    }
    
    public void printElements()
    {
        Tools.debugPrintln("Username: " + username);
        Tools.debugPrintln("Name: " + name);
        Tools.debugPrintln("Surname: " + surname);
        for(int i = 0; i< alEmail.size();i++)
            Tools.debugPrintln("Email["+(i+1)+"]: " + alEmail.get(i));
        Tools.debugPrintln("Date Of Birth: " +  df.format(dateOfBirth));
        switch(alCBooks.size()){
            case 0:
                break ;
            case 1:
                Tools.debugPrintln("- - - - - - - - - - - - - - - - - -");
                Tools.debugPrintln("Has taken 1 book :");                
                break ;
            default:
                Tools.debugPrintln("- - - - - - - - - - - - - - - - - -");
                Tools.debugPrintln("Has taken "+alCBooks.size()+" books :");            
        }
        for (CopyBook cb : alCBooks)            
            Tools.debugPrintln("B: ["+cb.getIdOfLibrary()+"], ISBN :["+cb.getBook().getISBN()+"]");        
        if (alCBooks.size()>0)
            Tools.debugPrintln("- - - - - - - - - - - - - - - - - -");
    }
    
    public String getInfoAboutMe()
    {
        String infoAboutMe = "(Person)" ;
        if (this instanceof Student)
            infoAboutMe = "(Student,"+((Student) this).getDepartment()+")";
        else if (this instanceof Staff)
            infoAboutMe ="(Staff,"+((Staff) this).getCapacity()+")";
        else if (this instanceof Professor)
            infoAboutMe = "(Professor,"+((Professor) this).getSpecialty()+")";
        
        return infoAboutMe ;
    }
    
    public void loanCopyBook(CopyBook cb)
    {
        alCBooks.add(cb) ;
    }
    
    public void returnedCopyBook(CopyBook cb)
    {
        alCBooks.remove(cb) ;
    }
  
    // Get και Set μέθοδοι:
    public String getUsername() {
        return username;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public ArrayList<String> getAlEmail() {
        return alEmail;
    }
    
    public String getAddress() {
        return address;
    }
    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public ArrayList<CopyBook> getAlCBooks() {
        return alCBooks;
    }   
       
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void setAlEmail(ArrayList<String> alEmail) {
        this.alEmail = alEmail;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAlCBooks(ArrayList<CopyBook> alCBooks) {
        this.alCBooks = alCBooks;
    }         
}
