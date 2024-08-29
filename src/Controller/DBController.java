/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.SQLException;
import Model.Book;
import Model.Borrower;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Set;
import org.apache.derby.iapi.sql.ResultSet;
/**
 *
 * @author wasch
 */
public class DBController {
    private DBConnection database;
    
    public DBController() throws ClassNotFoundException{
        this.database = new DBConnection();
        this.database.connect();
    }
    
    public void createBooksTable(){
        try{
            String query = "Create Table Books(BookSerial_ID varchar(20), BookName varchar(20), "
                    + "AuthorName varchar(20), AuthorSurname varchar(20), "
                    + "BorrowerUsername varchar(20), Condition varchar(20) )";
            database.con.createStatement().execute(query);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void createBorrowersTable(){
        try{
            String query = "Create Table Borrowers(Borrower_ID varchar(20), Username varchar(20), "
                    + "Name varchar(20), Surname varchar(20), "
                    + "Password varchar(20), PhoneNumber varchar(20), "
                    + "EmailAddress varchar(20) )";
            database.con.createStatement().execute(query);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    

    public void addBook(Book book){
        try{
            
            String query= "INSERT INTO Books(BookSerial_ID, BookName, AuthorName, AuthorSurname,"
                    + " BorrowerUsername, Condition) "
                    + "VALUES('"+book.getID()+"', '"+book.getTitle()+"', '"+book.getAuthorName()+"', "
                    + "'"+book.getAuthorSurname()+"', '"+book.getBorrowerUsername()+"', '"+book.getCondition()+"')";
            database.con.createStatement().execute(query);
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Data could not be added to table Books in database libraryManagementDB.");
        }
    }

    public void addBorrower(Borrower borrower){
        try{
            String query= "INSERT INTO Borrowers(Borrower_ID, Username, Name, Surname, Password, "
                    + "PhoneNumber, EmailAddress) "
                    + "VALUES('"+borrower.getUserID()+"', "
                    + "'"+borrower.getUsername()+"', '"+borrower.getName()+"', '"+borrower.getSurname()+"', "
                    + "'"+borrower.getPassword()+"', '"+borrower.getPhoneNumber()+"', "
                    + "'"+borrower.getEmailAddress()+"')";
            database.con.createStatement().execute(query);
            System.out.println(query+"\n <-added");
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Data could not be added to table Borrowers in database libraryManagementDB.");
        }
    }
    
    public void removeBook(Book book){
        try{
            String query= "DELETE FROM Books "
                    + "WHERE BookSerial_ID = '"+book.getID()+"'";
            database.con.createStatement().execute(query);
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("This data could not be removed from table Books in database libraryManagementDB.");
        } 
    }

    public void removeBorrower(Borrower borrower){
         try{
            String query= "DELETE FROM Borrowers "
                    + "WHERE Username = '"+borrower.getUsername()+"'";
            database.con.createStatement().execute(query);
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("This data could not be removed from table Borrowers in database libraryManagementDB.");
        }
    }
   
    public void updateBook(Book book){
        try{
            String query= "UPDATE Books SET BookSerial_ID = '"+book.getID()+"', "
                    + "BookName = '"+book.getTitle()+"', AuthorName = '"+book.getAuthorName()+"', "
                    + "AuthorSurname = '"+book.getAuthorSurname()+"', BorrowerUsername = '"+book.getBorrowerUsername()+"', "
                    + "Condition = '"+book.getCondition()+"' "
                    + "WHERE BookSerial_ID = '"+book.getID()+"'";
            database.con.createStatement().execute(query);
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("The data couldn't be updated to table Books in database libraryManagementDB.");
        } 
    }
  
    public void updateBorrower(Borrower borrower){
        try{
            String query= "UPDATE Borrowers SET Borrower_ID = '"+borrower.getUserID()+"', "
                    + "Username = '"+borrower.getUsername()+"', Name = '"+borrower.getName()+"', "
                    + "Surname = '"+borrower.getSurname()+"', Password = '"+borrower.getPassword()+"', "
                    + "PhoneNumber = '"+borrower.getPhoneNumber()+"', EmailAddress = '"+borrower.getEmailAddress()+"' "
                    + "WHERE Username = '"+borrower.getUsername()+"'";
            database.con.createStatement().execute(query);
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("The data couldn't be updated to table Borrowers in database libraryManagementDB.");
        } 
    }
     /*                 Create Table Books(BookSerial_ID varchar(20), BookName varchar(20), "
                    + "AuthorName varchar(20), AuthorSurname varchar(20), "
                    + "BorrowerUsername varchar(20), Condition varchar(20) )
    */
    /*ISBN
Title
Author
Condition
Status*/
    public ArrayList<Book> searchBook(String data, String method){
        return database.getSearchedBooks(data, method);
    }
    /*
                    String query = "Create Table Borrowers(Borrower_ID varchar(20), Username varchar(20), "
                    + "Name varchar(20), Surname varchar(20), "
                    + "Password varchar(20), PhoneNumber varchar(20), "
                    + "EmailAddress varchar(20) )"
    */
    public Set<Borrower> searchBorrowers(String data, String method){
        return database.getSearchedBorrowers(data, method);
    }
    public ArrayList<Book> getBooks(){
        return database.getBooks();
    }
    
    public Set<Borrower> getBorrowers(){
       return database.getBorrower();
    }
}
