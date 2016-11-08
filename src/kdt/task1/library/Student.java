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

import java.util.ArrayList;
import java.util.Date;
import kdt.task1.global.*;

/**
 * Kλάση για να διαχειριζόμαστε τους Φοιτητές.
 */
public class Student extends Person {
    private String am ;
    private String faculty ;
    private String department ;
    
    public Student(String username, String name, String surname,String am,String faculty, String department) {
        super(username, name, surname);
        this.am = am;
        this.faculty = faculty;
        this.department = department;
    }
    
    public Student(String username, String name, String surname, ArrayList<String> alEmail, String address, Date dateOfBirth,String am, String faculty, String department) {
        super(username, name, surname, alEmail, address, dateOfBirth);
        this.am = am;
        this.faculty = faculty;
        this.department = department;
    }
    @Override
    public void printElements() {
        Tools.debugPrintln("*********** A Student ************");
        super.printElements();        
        Tools.debugPrintln("AM: " + am);
        Tools.debugPrintln("Faculty: " + faculty);
        Tools.debugPrintln("Department: " + department);
        Tools.debugPrintln("*********** Student - End ************");
    }
    
    // Get και Set μέθοδοι:    
    public String getAm() {
        return am;
    }

    public String getFaculty() {
        return faculty;
    }
    
    public String getDepartment() {
        return department;
    }

    public void setAm(String am) {
        this.am = am;
    }
    
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
}
