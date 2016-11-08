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
import kdt.task1.global.Tools;

/**
 * Κλάση για να διαχειριζόμαστε τα βιβλία.
 */
public class Book {
    //Ενδεικτικά 3 κατηγορίες βιβλίων.
    public enum Categ{
        computer
        ,literature
        ,physics
    }
    static protected DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private String title ;
    private String ISBN ;
    private int pages ;
    private ArrayList<String> authors ;
    private String publisher ;
    private String summary ;
    private Categ category ;
    private Date releaseDate ;
    private ArrayList<CopyBook> copies ;    
    
    public Book(String title, String ISBN, int pages, ArrayList<String> authors, String publisher, String summary, Categ category, Date releaseDate) {
        this.title = title;
        this.ISBN = ISBN;
        this.pages = pages;
        this.authors = authors;
        this.publisher = publisher;
        this.summary = summary;
        this.category = category;
        this.releaseDate = releaseDate;
    }
    
    public void printElements()
    {
        Tools.debugPrintln("Title: " + title);
        Tools.debugPrintln("ISBN: " + ISBN);
        Tools.debugPrintln("Pages: " + pages);
        for(int i=0;i<authors.size();i++)
            Tools.debugPrintln("Author["+(i+1)+"]: " + authors.get(i));
        Tools.debugPrintln("Publisher: " + publisher);
        //Tools.debugPrintln("Summary: " + summary);
        Tools.debugPrintln("Category: " + category.toString());
        Tools.debugPrintln("Release Date: " +  df.format(releaseDate));
        Tools.debugPrintln("Αντίγραφα που υπάρχουν: " +  copies.size());
    }
    
    // Get και Set μέθοδοι:
    public String getTitle() {
        return title;
    }
    
    public String getISBN() {
        return ISBN;
    }
    
    public int getPages() {
        return pages;
    }
    
    public ArrayList<String> getAuthors() {
        return authors;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public String getSummary() {
        return summary;
    }
    
    public Categ getCategory() {
        return category;
    }
    
    public Date getReleaseDate() {
        return releaseDate;
    }
    
    public ArrayList<CopyBook> getCopies() {
        return copies;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    public void setPages(int pages) {
        this.pages = pages;
    }
    
    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public void setSummary(String summary) {
        this.summary = summary;
    }
    
    public void setCategory(Categ category) {
        this.category = category;
    }
    
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public void setCopies(ArrayList<CopyBook> copies) {
        this.copies = copies;
    }    
}
