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

/**
 * Κλάση για να διαχειριζόμαστε τις τοποθεσίες των βιβλίων.
 */
public class LocationOfCopyBook {
    private int floor ;
    private int passageway ;
    private int bookshelf ;    
    private int averageBooksThatFits ;
    private ArrayList<CopyBook> alCopyBooks; //Ποια αντίτυπα βιβλίων είναι στη συγκεκριμένη
                                             // τοποθεσία - ράφι.

    public LocationOfCopyBook(int floor, int passageway, int bookshelf, int averageBooksThatFits) {
        this.floor = floor;
        this.passageway = passageway;
        this.bookshelf = bookshelf;
        this.averageBooksThatFits = averageBooksThatFits;
        alCopyBooks = new ArrayList<>() ;
    }

    @Override
    public String toString() {
        return "{" + floor + ", " + passageway + ", " + bookshelf + "}";
    }         
    
    public void addCopyBook(CopyBook cb)
    {
        alCopyBooks.add(cb) ;
    }
    
    public void removeCopyBook(CopyBook cb)
    {
        alCopyBooks.remove(cb) ;
    }
    
    // Get και Set μέθοδοι:
    public int getFloor() {
        return floor;
    }

    public int getPassageway() {
        return passageway;
    }

    public int getBookshelf() {
        return bookshelf;
    }

    public int getAverageBooksThatFits() {
        return averageBooksThatFits;
    }   

    public ArrayList<CopyBook> getAlCopyBooks() {
        return alCopyBooks;
    }
    
    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setPassageway(int passageway) {
        this.passageway = passageway;
    }

    public void setBookshelf(int bookshelf) {
        this.bookshelf = bookshelf;
    }

    public void setAverageBooksThatFits(int averageBooksThatFits) {
        this.averageBooksThatFits = averageBooksThatFits;
    } 

    public void setAlCopyBooks(ArrayList<CopyBook> alCopyBooks) {
        this.alCopyBooks = alCopyBooks;
    }    
}
