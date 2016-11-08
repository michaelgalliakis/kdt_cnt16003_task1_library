 /**
  * TEI of Athens, Department of Informatics
  * Master of Science in Computing and Network Technologies
  * Distributed Web Applications, Task 1 Ενδεικτική λύση,
  * Subject: Πληροφοριακό Σύστημα Βιβλιοθήκης (Βιβλία, Φοιτητές,
  * Διαφορετικές καταστάσεις σε βιβλία -διαθέσιμο ή όχι, τοποθεσίες βιβλίων).
  * @author Michael Galliakis AM: CNT16003.
  * Ημερομηνία : 1/11/2016
  */
package kdt.task1.global;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Κλάση που έχει κάποιους χρήσιμους static μεθόδους (σαν "εργαλεία") με σκοπό
 * να καλούνται από άλλα σημεία μέσα στο project.
 */
public class Tools {
    static public Random random = new Random() ;
    static public BufferedWriter writer = null;
    
    /**
     * Για το άνοιγμα του text αρχείου, που θα γράφετε το output
     * @param path το μονοπάτι του text αρχείου που θα δημιουργηθεί.
     */
    static public void prepareWriter(String path)
    {
        try {
            writer = new BufferedWriter(new FileWriter(path));
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Υπήρξε ΣΦΑΛΜΑ στο άνοιγμα αρχείου εγγραφής!");
        }
    }
    
    /**
     * Κλείνει το text αρχείο.
     */
    static public void closeWriter()
    {
        try {
            if (writer!=null)
            {
                writer.close();
                writer = null ;
            }
        } catch (IOException ex) {
            //Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Εμφανίζει ένα μήνυμα στην standard έξοδο όπως επίσης γράφει το ίδιο
     * μήνυμα σε ένα αρχείο. (Δεν αλλάζει γραμμή μετά την εγγραφή του μηνύματος)
     * @param mess Το μήνυμα που θα τυπωθεί.
     */
    static public void debugPrint(String mess)
    {
        System.out.print(mess);
        if (writer!=null) // Δηλαδή εάν έχει δηλωθεί κάποιο αρχείο κειμένου
        {
            try {
                writer.write(mess);
            } catch (IOException ex) {
                System.out.println("ΣΦΑΛΜΑ κατά την εγγραφή του αρχείου!");
            }
        }
    }
    /**
     * Εμφανίζει ένα μήνυμα στην standard έξοδο όπως επίσης γράφει το ίδιο
     * μήνυμα σε ένα αρχείο. (Αλλάζει γραμμή μετά την εγγραφή του μηνύματος)
     * @param mess Το μήνυμα που θα τυπωθεί.
     */
    static public void debugPrintln(String mess)
    {
        System.out.println(mess);
        if (writer!=null) // Δηλαδή εάν έχει δηλωθεί κάποιο αρχείο κειμένου
        {
            try {
                writer.write(mess);
                writer.newLine();
            } catch (IOException ex) {
                System.out.println("ΣΦΑΛΜΑ κατά την εγγραφή του αρχείου!");
            }
        }
    }
    
    final static private String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ    " ;
    final static private String NUMBERS = "0123456789" ;
    /**
     * Επιστρέφει μια τυχαία συμβολοσειρά.
     * @param minChars Τον πλήθος των ελάχιστων χαρακτήρων που θα έχει η γραμματοσειρά
     * @param lenRandomChars Το πλήθος των επιπλέον τυχαίων χαρακτήρων που θα έχει η γραμματοσειρά
     * @param isISBN Αν είναι true τότε επιστρέφει ένα 13ψήφιο string και δεν παίρνει
     * υπόψιν του το lenRandomChars και το minChars.
     * @return Ένα τυχαίο string.
     */
    static public String getDummyString(int minChars,int lenRandomChars,boolean isISBN)
    {
        int stringSize = (isISBN)?13:random.nextInt(lenRandomChars)+minChars ;
        String lottery = (isISBN)?NUMBERS:CHARS ;
        
        String tmp = "" ;
        for(int i = 0 ; i< stringSize;i++)
            tmp += lottery.charAt(random.nextInt(lottery.length())) ;
        
        return tmp ;
    }
    /**
     * Επιστρέφει μια τυχαία συμβολοσειρά.
     * @param minChars Τον πλήθος των ελάχιστων χαρακτήρων που θα έχει η γραμματοσειρά
     * @param lenRandomChars Το πλήθος των επιπλέον τυχαίων χαρακτήρων που θα έχει η γραμματοσειρά
     * @return Ένα τυχαίο string.
     */
    static public String getDummyString(int minChars,int lenRandomChars)
    {
        return getDummyString(minChars,lenRandomChars,false);
    }
}
