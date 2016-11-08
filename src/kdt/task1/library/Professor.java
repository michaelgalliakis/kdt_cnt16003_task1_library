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
 * Kλάση για να διαχειριζόμαστε τους καθηγητές.
 */
public class Professor extends Person {
    private String specialty ;
    private ArrayList<String> alLessons;
    
    public Professor(String username, String name, String surname,String specialty, ArrayList<String> alLessons) {
        super(username, name, surname);
        this.specialty = specialty;
        this.alLessons = alLessons;
    }
    
    public Professor(String username, String name, String surname, ArrayList<String> alEmail, String address, Date dateOfBirth,String specialty, ArrayList<String> alLessons) {
        super(username, name, surname, alEmail, address, dateOfBirth);
        this.specialty = specialty;
        this.alLessons = alLessons;
    }
    
    @Override
    public void printElements() {
        Tools.debugPrintln("*********** A Professor ************");
        super.printElements();
        Tools.debugPrintln("Specialty: "+ specialty);
        for(int i = 0; i<alLessons.size();i++)
            Tools.debugPrintln("Lesson["+(i+1)+"]: " + alLessons.get(i));
        Tools.debugPrintln("*********** Professor - End ************");
    }
    
    // Get και Set μέθοδοι:
    public String getSpecialty() {
        return specialty;
    }
    
    public ArrayList<String> getAlLessons() {
        return alLessons;
    }
    
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    
    public void setAlLessons(ArrayList<String> alLessons) {
        this.alLessons = alLessons;
    }
}
