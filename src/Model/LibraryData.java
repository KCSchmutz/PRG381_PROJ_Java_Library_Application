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
        String[][] temp = new String[borrowers.size()][5];
        int i=0;
        for(Borrower borrowed : borrowers){
            temp[i][0] = borrowed.getUsername();
            temp[i][1] = borrowed.getName();
            temp[i][2] = borrowed.getSurname();
            temp[i][3] = borrowed.getPhoneNumber();
            temp[i][4] = borrowed.getEmailAddress();
            i++;
        }
        return temp;
    }
}
