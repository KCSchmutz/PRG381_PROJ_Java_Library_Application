/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author wasch
 */
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
