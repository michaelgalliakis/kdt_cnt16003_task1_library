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
 * Kλάση για να διαχειριζόμαστε γενικά το προσωπικό (πχ γραμματείς).
 */
public class Staff extends Person {
    private String capacity ;
    
    public Staff(String username, String name, String surname, String capacity) {
        super(username, name, surname);
        this.capacity = capacity;
    }
    
    public Staff(String username, String name, String surname, ArrayList<String> alEmail, String address, Date dateOfBirth, String capacity) {
        super(username, name, surname, alEmail, address, dateOfBirth);
        this.capacity = capacity;
    }
    
    @Override
    public void printElements() {
        Tools.debugPrintln("*********** A Staff ************");
        super.printElements();
        Tools.debugPrintln("Capacity: "+ capacity);
        Tools.debugPrintln("*********** Staff - End ************");
    }
    
    // Get και Set μέθοδοι:
    public String getCapacity() {
        return capacity;
    }
    
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}
