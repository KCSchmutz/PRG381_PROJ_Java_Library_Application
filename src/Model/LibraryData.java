package Model;

import java.util.ArrayList;
import java.util.Set;

public class LibraryData {
    ArrayList<Book> books;
    Set<Borrower> borrowers;
    
    public LibraryData(ArrayList<Book> books, Set<Borrower> borrowers){
        this.books = books;
        this.borrowers = borrowers;
    }
    
    public void addBook(Book book){
        books.add(book);
    }
    
    public void addBorrower(Borrower borrower){
        borrowers.add(borrower);
    }
    
    
}
