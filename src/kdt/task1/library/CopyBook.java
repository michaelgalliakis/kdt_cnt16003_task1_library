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

import java.util.Date;
import kdt.task1.global.Tools;

/**
 * Κλάση για να διαχειριζόμαστε να αντίγραφα των βιβλίων.
 */
public class CopyBook {
    private Book book ;
    private String idOfLibrary ;
    private boolean available ;
    private Date dateLoan ;
    private Date suggestedReturnDate ;
    private Person curBorrower ;
    private LocationOfCopyBook locationOfCopyBook ;
    
    public CopyBook(Book book, String idOfLibrary, LocationOfCopyBook locationOfCopyBook) {
        this.book = book;
        this.idOfLibrary = idOfLibrary;
        this.locationOfCopyBook = locationOfCopyBook ;
        available = true ;
    }
    
    public boolean loanCopyBook(Date dl,Date srd, Person p) //Return "state"
    {
        if (isAvailable())
        {
            dateLoan = dl;
            suggestedReturnDate = srd ;
            curBorrower = p ;
            curBorrower.loanCopyBook(this);
            available = false ;
            return true ;
        }
        else
            return false ;
    }
    
    public void returnedCopyBook()
    {
        available = true ;
        dateLoan = null ;
        suggestedReturnDate = null ;
        if (curBorrower!=null)
        {
            curBorrower.returnedCopyBook(this);
            curBorrower = null ;
        }
    }
    
    public void printElements()
    {
        printElements(false);
    }
    public void printElements(boolean printTitleAndISBN)
    {
        Tools.debugPrintln("----------------------------------------------------------------");
        Tools.debugPrintln("ID Of Library: " + idOfLibrary);
        if (printTitleAndISBN){
            Tools.debugPrintln("Title: "+book.getTitle() );
            Tools.debugPrintln("ISBN: "+book.getISBN() );
        }
        
        if (!available)
        {
            Tools.debugPrintln("Δεν είναι διαθέσιμο, το έχει πάρει ο : " +  curBorrower.getUsername());
            Tools.debugPrintln("Date Loan: " +  Book.df.format(dateLoan));
            Tools.debugPrintln("Suggested Return Date: " +  Book.df.format(suggestedReturnDate));
        }
        else
            Tools.debugPrintln("Ειναι διαθέσιμο στο: " + locationOfCopyBook + " σημείο της βιβλιοθήκης!");
        
        Tools.debugPrintln("----------------------------------------------------------------");
    }
    
    // Get και Set μέθοδοι:
    public Book getBook() {
        return book;
    }
    
    public String getIdOfLibrary() {
        return idOfLibrary;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public Date getDateLoan() {
        return dateLoan;
    }
    
    public Date getSuggestedReturnDate() {
        return suggestedReturnDate;
    }
    
    public Person getCurBorrower() {
        return curBorrower;
    }
    
    public LocationOfCopyBook getLocationOfCopyBook() {
        return locationOfCopyBook;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }
    
    public void setIdOfLibrary(String idOfLibrary) {
        this.idOfLibrary = idOfLibrary;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public void setDateLoan(Date dateLoan) {
        this.dateLoan = dateLoan;
    }
    
    public void setSuggestedReturnDate(Date suggestedReturnDate) {
        this.suggestedReturnDate = suggestedReturnDate;
    }
    
    public void setCurBorrower(Person curBorrower) {
        this.curBorrower = curBorrower;
    }
    
    public void setLocationOfCopyBook(LocationOfCopyBook locationOfCopyBook) {
        this.locationOfCopyBook = locationOfCopyBook;
    }    
}
