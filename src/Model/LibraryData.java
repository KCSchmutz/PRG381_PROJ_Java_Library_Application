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
    /*"Create Table Books(BookSerial_ID varchar(20), BookName varchar(20), "
                    + "AuthorName varchar(20), AuthorSurname varchar(20), "
                    + "BorrowerUsername varchar(20), Condition varchar(20) )";
    /*Borrower(rs.getString("Borrower_ID"),rs.getString("Username"),
                rs.getString("Name"),rs.getString("Surname"),rs.getString("Password"),
                rs.getString("PhoneNumber"),rs.getString("EmailAddress")));*/
    public String[][] getBooks(){
        String[][] temp = new String[books.size()][5];
        for (int i=0;i<books.size();i++){
            temp[i][0]=books.get(i).getID();
            temp[i][1]=books.get(i).getTitle();
            temp[i][2]=books.get(i).getAuthorName()+books.get(i).getAuthorSurname();
            temp[i][3]=books.get(i).getBorrowerUsername();
            temp[i][4]=books.get(i).getCondition();
        }
        return temp;
    }
    
    public String[][] getBorrowers(){
        String[][] temp = new String[borrowers.size()][7];
        Borrower[] borrowing = new Borrower[borrowers.size()];
        borrowing = (Borrower[]) borrowers.toArray();
        for (int i=0;i<borrowers.size();i++){
            temp[i][0] = borrowing[i].getUserID();
            temp[i][1] = borrowing[i].getUsername();
            temp[i][2] = borrowing[i].getName();
            temp[i][3] = borrowing[i].getSurname();
            temp[i][4] = borrowing[i].getPassword();
            temp[i][5] = borrowing[i].getPhoneNumber();
            temp[i][5] = borrowing[i].getEmailAddress();
        }
        return temp;
    }
}
