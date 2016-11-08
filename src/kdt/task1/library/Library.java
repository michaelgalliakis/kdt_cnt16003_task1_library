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

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import kdt.task1.global.*;

/**
 * Κλάση για να διαχειριζόμαστε όλη την βιβλιοθήκη.
 */
public class Library {
    final static public String INSTITUTE = "Library * * * TEI of Athens, by P.M.G (CNT16003)" ;
    static private Library instance = new Library() ;
    
    public ArrayList<Book> alAllBooks ;
    public ArrayList<LocationOfCopyBook> alAllLocations ;
    
    private Library() {
        //Δημιουργία των τοποθεσιών:
        alAllLocations = createLocationsOfCopyBooks() ;
        //Δημιουργία των βιβλίων:
        alAllBooks = generateDummyCopyBooks(3) ;        
    }
    
    public static Library getInstance() {
        return instance;
    }
    
    //Ένα ενδεικτικό σενάριο χρήσης::
    public static void main(String[] args)
    {
        Tools.prepareWriter("/home/michael/Desktop/runScenario3.txt"); // Ανοίγει το text αρχείο!
        
        Tools.debugPrintln(INSTITUTE);
        
        Library lib = Library.getInstance() ;
        HashMap<String,Person> hmPersons  = getScenarioPersons() ;
        
        //Εμφάνιση των 4 ατόμων που δημιουργήθηκαν για το σενάριο μας
        Tools.debugPrintln("###Εμφάνιση 4 ατόμων που δημιουργήθηκαν για το σενάριο###");
        for(Person p : hmPersons.values())
            p.printElements();
        
        //Εμφάνιση όλων των βιβλίων:
        Tools.debugPrintln("###########Εμφάνιση όλων των βιβλίων#########");
        lib.printAllBooks();
        
        //Ενδεικτικά κάποιες ενέργεις που γίνονται στην βιβλιοθήκη:
        Tools.debugPrintln("####Ενδεικτικά κάποιες ενέργεις που γίνονται στην βιβλιοθήκη####");
        
        CopyBook cb = lib.alAllBooks.get(0).getCopies().get(lib.alAllBooks.get(0).getCopies().size()/2) ;
        Tools.debugPrintln("&&&&(1) Δανείζεται το βιβλίο &&&&&");
        lib.loanBook(cb,hmPersons.get("gvalonakis")) ;
        
        Tools.debugPrintln("&&&&(2) Πάει άλλος να δανειστεί το ίδιο βιβλίο &&&&&");
        lib.loanBook(cb,hmPersons.get("mgalliakis")) ;
        
        CopyBook cb2 = lib.alAllBooks.get(0).getCopies().get(0) ;
        Tools.debugPrintln("&&&&(3) Ο ίδιος χρήστης δανειζεται άλλο αντίτυπο του βιβλίου που ήθελε &&&&&");
        lib.loanBook(cb2,hmPersons.get("mgalliakis")) ;
        
        Tools.debugPrintln("&&&&(4) Επιστροφή βιβλίου &&&&&");
        lib.returnBook(cb);
        
        Tools.debugPrintln("&&&&(5) Το επιστρεμένο αντίτυπο το δανείζεται νέος χρήστης &&&&&");
        lib.loanBook(cb,hmPersons.get("mgeorgatou")) ;
        
        Tools.debugPrintln("&&&&(6) Άλλος ένας δανεισμός βιβλίου &&&&&");
        CopyBook cb3 = lib.alAllBooks.get(1).getCopies().get(lib.alAllBooks.get(1).getCopies().size()/2) ;
        lib.loanBook(cb3,hmPersons.get("itakoglou")) ;
        
        Tools.debugPrintln("&&&&(7) Ακόμη ένας δανεισμός βιβλίου &&&&&");
        CopyBook cb4 = lib.alAllBooks.get(2).getCopies().get(lib.alAllBooks.get(2).getCopies().size()-1) ;
        lib.loanBook(cb4,hmPersons.get("mgeorgatou")) ;
        
        Tools.debugPrintln("##Εμφάνιση αυτή τη φορά όλων των βιβλίων μαζί με τα αντίτυπα τους##");
        lib.printAllBooks(true);
        
        //Εμφάνιση των 4 ατόμων που δημιουργήθηκαν για το σενάριο μας
        Tools.debugPrintln("###Εμφάνιση πάλι των 4 ατόμων που δημιουργήθηκαν για το σενάριο###");
        for(Person p : hmPersons.values())
            p.printElements();
        
        //Εμφάνιση των αντίτυπων βιβλίων που είναι διαθέσιμα στην βιβλιοθήκη, με βάση τις τοποθεσίες.
        lib.printLocationWithBooks();
        
        Tools.closeWriter(); //Κλείνει το text αρχείο!
    }
    
    /**
     * Διαδικασία για την επιστροφή κάποιου βιβλίου (αντίτυπου).
     * @param cb  Ένα {@link CopyBook} που θα επιστραφεί.
     */
    public void returnBook(CopyBook cb)
    {
        Person p = cb.getCurBorrower() ;
        cb.returnedCopyBook();
        
        Tools.debugPrintln("Επιστράφηκε το αντιτυπό "+cb.getIdOfLibrary()
                +" του βιβλίου ["+ cb.getBook().getTitle() + "]" +
                ((p!=null)?" από τον: "+p.getUsername()+p.getInfoAboutMe():"")+".");
    }
    
    /**
     * Ενδεικτική διαδικασία για τον δανεισμό κάποιου βιβλίου (αντίτυπου) σε κάποιο άτομο.
     * @param cb  Το {@link CopyBook} που θα δοθεί για δανεισμό.
     * @param p Το {@link Person} που θα δανειστεί το βιβλίο.
     * @return True αν όλα πήγαν καλά και false αν υπήρξε κάποιο σφάλμα.
     */
    public boolean loanBook(CopyBook cb,Person p)
    {
        if (p==null)
        {
            Tools.debugPrintln("Σφάλμα! Δεν υπάρχει αυτό το άτομο στην λίστα εγγεγραμμένων χρηστών.");
            return false ;
        }
        try {
            if (cb.isAvailable())
            {
                Date newDate = new Date() ;
                Calendar c = Calendar.getInstance();
                c.setTime(newDate);
                c.add(Calendar.DATE, 15);
                cb.loanCopyBook(newDate, c.getTime() , p) ;
                Tools.debugPrintln("Δόθηκε το αντιτυπό "+cb.getIdOfLibrary()
                        +" του βιβλίου ["+ cb.getBook().getTitle() +
                        "] στον: "+ p.getUsername()+p.getInfoAboutMe()+".");
                
                Tools.debugPrintln("Το πήρε "+Book.df.format(cb.getDateLoan()) +" και πρέπει να το επιστρέψει στις ["
                        +Book.df.format(cb.getSuggestedReturnDate())+"]");
            }
            else
            {
                Tools.debugPrintln("Προσοχή! Δεν είναι διαθέσιμο το αντιτυπό "+cb.getIdOfLibrary()
                        +" του βιβλίου ["+ cb.getBook().getTitle() +"]"
                        +" διότι έχει δωθεί στον " + cb.getCurBorrower().getUsername()+
                        cb.getCurBorrower().getInfoAboutMe()+".");
                
                for (CopyBook tmpCb :cb.getBook().getCopies())
                {
                    if (tmpCb.isAvailable())
                        Tools.debugPrintln("Υπάρχει όμως διαθέσιμο το ίδιο βιβλίο με κωδικό: "+tmpCb.getIdOfLibrary()
                                +" στη τοποθεσία: " +tmpCb.getLocationOfCopyBook());
                }
            }
        }
        catch (Exception e)
        {
            Tools.debugPrintln("Υπήρξε κάποιο σφάλμα!") ;
            return false ;
        }
        
        return true ;
    }
    
    /**
     * Τυπώνει τις τοποθεσίες που έχουν διαθέσιμα βιβλία, μαζί με τα βιβλία που έχουν.     
     */
    public void printLocationWithBooks()
    {
        Tools.debugPrintln("^^^^^^^^Begin^^^^^^^^");
        for(LocationOfCopyBook loc : alAllLocations)
        {
            if (loc.getAlCopyBooks().size()>0)
            {
                Tools.debugPrintln("Στην τοποθεσία: "+loc+" υπάρχουν διαθέσιμα τα εξής βιβλία:");
                for (CopyBook cb: loc.getAlCopyBooks())
                    if (cb.isAvailable())
                        Tools.debugPrintln("IDofLib: "+cb.getIdOfLibrary() +", ISBN: "+ cb.getBook().getISBN());
                Tools.debugPrintln("$$$$$$$$$$$$-*-*-*-*-*-$$$$$$$$$$");
            }                        
        }
        Tools.debugPrintln("^^^^^^^^^End^^^^^^^^^");
    }
    
    /**
     * Τυπώνει όλα τα βιβλία που έχει η βιβλιοθήκη.
     */
    public void printAllBooks()
    {
        printAllBooks(false) ;
    }
    
    /**
     * Τυπώνει όλα τα βιβλία που έχει η βιβλιοθήκη.
     * @param andCopies Αν true, εμφανίζει και όλα τα αντίτυπα τους.
     */
    public void printAllBooks(boolean andCopies)
    {
        Tools.debugPrintln("$$$$$$$$$$$$Begin$$$$$$$$$$");
        for(Book book : alAllBooks)
        {
            book.printElements();
            if (andCopies)
            {
                for(CopyBook cp : book.getCopies())
                    cp.printElements();
                
            }
            Tools.debugPrintln("$$$$$$$$$$$$-*-*-*-*-*-$$$$$$$$$$");
        }
        Tools.debugPrintln("$$$$$$$$$$End$$$$$$$$$$");
    }
    
    //****************** Scenario tools methods **********************//    
    /**
     * Μέθοδος που αναλαμβάνει να δημιουργήσει τυχαία βιβλία
     * για να έχει η βιβλιοθήκη.
     * @param numberOfBooks Ο πλήθος των τυχαίων βιβλίων που θα φτιαχτούν
     * @return Μια λίστα με όλα τα τυχαία βιβλία που φτιάχτηκαν.
     */
    public ArrayList<Book> generateDummyCopyBooks(int numberOfBooks)
    {
        ArrayList<Book> alBooks = new ArrayList();
        
        for (int i = 0 ; i<numberOfBooks;i++)
        {
            int cat = Tools.random.nextInt(Book.Categ.values().length) ;
            ArrayList<String> alAuthors = new ArrayList() ;
            alAuthors.add(Tools.getDummyString(10, 30)) ;
            alAuthors.add(Tools.getDummyString(10, 30)) ;
            Book book = new Book(Tools.getDummyString(10, 30),
                    Tools.getDummyString(20, 20,true),
                    Tools.random.nextInt(700)+150,
                    alAuthors,
                    Tools.getDummyString(10, 35),
                    Tools.getDummyString(600, 250),
                    (cat==0)?Book.Categ.computer:((cat==1)?Book.Categ.literature:Book.Categ.physics),
                    new Date()) ;
            alBooks.add(book) ;
            
            int numberOfCopies = Tools.random.nextInt(5)+3 ;
            
            ArrayList<CopyBook> alCopyBook = new ArrayList() ;
            LocationOfCopyBook lcb = alAllLocations.get(Tools.random.nextInt(alAllLocations.size()));
            for (int j = 0 ; j<numberOfCopies;j++)
            {
                CopyBook cp = new CopyBook(book,"CBID:"+ String.valueOf(j),lcb);                
                alCopyBook.add(cp) ;
                lcb.addCopyBook(cp);
            }
            book.setCopies(alCopyBook);
        }
        
        return alBooks;
    }
    
    /**
     * Μεθοδος που δημιουργεί τις τοποθεσίες των βιβλίων για την βιβλιοθήκη.
     * @return Μια λίστα με τοποθεσίες ({@link LocationOfCopyBook}).
     */
    static public ArrayList<LocationOfCopyBook> createLocationsOfCopyBooks()
    {
        ArrayList<LocationOfCopyBook> tmpAlLoc = new ArrayList<>() ;
                 
        for (int floor=0; floor<5;floor++)
            for (int passageway=1; passageway<10;passageway++)
                for (int bookshelf=1; bookshelf<24;bookshelf++)
                    tmpAlLoc.add(new LocationOfCopyBook(floor, passageway, bookshelf,Tools.random.nextInt(25)+10));
        return tmpAlLoc ;
    }
    
    /**
     * Μέθοδος για τη δημιουργία 4 ατομών (2 Student,1 Professor και 1 Staff)
     * ώστε να χρησιμοποιηθεί από την main για ένα σενάριο χρήσης.
     * @return Επιστρέφει ένα hashmap με τα 4 άτομα (Κλειδί  το username).
     */
    static public HashMap<String,Person> getScenarioPersons()
    {
        HashMap<String,Person> hmPersons = new HashMap() ;
        
        //Δημιουργία 4 ατόμων για να μπορούν δανείζονται βιβλία : Begin
        Student stud1 = new Student("gvalonakis", "Georgios", "Valonakis","CS081019" ,"SDO", "Business Administrator") ;
        
        hmPersons.put(stud1.getUsername(), stud1) ;
        
        ArrayList<String> alTmpEmail = new ArrayList() ;
        alTmpEmail.add("mike@gmail.com") ;
        alTmpEmail.add("mike@yahoo.gr") ;
        alTmpEmail.add("cnt16003@teiath.gr") ;
        LocalDate localDate = LocalDate.of( 1991 , Month.JANUARY , 18 );
        Student stud2 = new Student("mgalliakis", "Mike", "Gall",alTmpEmail,"Edessis, Aigaleo",
                Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),"cnt16003",
                "STEF", "Informatics");
        hmPersons.put(stud2.getUsername(), stud2) ;
        
        ArrayList<String> alTmpLessons = new ArrayList() ;
        alTmpLessons.add("Distributed Dystems") ;
        alTmpLessons.add("Systems Databases") ;
        Professor prof = new Professor("itakoglou","Iordanis", "Takoglou","IT", alTmpLessons) ;
        hmPersons.put(prof.getUsername(), prof) ;
        
        Staff staff = new Staff("mgeorgatou", "Maria", "Georgatou", "Secretarial Support") ;
        hmPersons.put(staff.getUsername(), staff) ;
        
        //Δημιουργία 4 ατόμων για να μπορούν δανείζονται βιβλία : End
        return hmPersons ;
    }
}