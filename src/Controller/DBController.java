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
    /*Create Table Books(BookSerial_ID varchar(20), BookName varchar(20), "
                    + "AuthorName varchar(20), AuthorSurname varchar(20), "
                    + "BorrowerUsername varchar(20), Condition varchar(20) )
    */
    
    /*
    I would also recommend using prepared statements, not only is it more readable but also will prevent you from SQL injection attacks. More info here

Example:

preparedStatement = connection.prepareStatement("INSERT INTO EMPLOYEES (fname, lname, email) VALUES (?, ?, ?)");
preparedStatement.setString(1, person.getFName());
preparedStatement.setString(2, person.getLName());
preparedStatement.setString(3, person.getEmail());
    */
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
    /*
                    String query = "Create Table Borrowers(Borrower_ID varchar(20), Username varchar(20), "
                    + "Name varchar(20), Surname varchar(20), "
                    + "Password varchar(20), PhoneNumber varchar(20), "
                    + "EmailAddress varchar(20) )"
    */
    public void addBorrower(Borrower borrower){
        try{
            String query= "INSERT INTO Borrower(Borrower_ID, Username, Name, Surname, Password, "
                    + "PhoneNumber, EmailAddress) "
                    + "VALUES('"+borrower.getUserID()+"', "
                    + "'"+borrower.getUsername()+"', '"+borrower.getName()+"', '"+borrower.getSurname()+"'"
                    + "'"+borrower.getPassword()+"', '"+borrower.getPhoneNumber()+"'"
                    + "'"+borrower.getEmailAddress()+"')";
            database.con.createStatement().execute(query);
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
            String query= "DELETE FROM Books "
                    + "WHERE Borrower_ID = '"+borrower.getUserID()+"'";
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
                    + "Condition = '"+book.getCondition()+"', "
                    + "WHERE BookSerial_ID = '"+book.getID()+"';";
            database.con.createStatement().execute(query);
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("The data couldn't be updated to table Books in database libraryManagementDB.");
        } 
    }
  
    public void updateBorrower(Borrower borrower){
        try{
            String query= "UPDATE Books SET Borrower_ID = '"+borrower.getUserID()+"', "
                    + "Username = '"+borrower.getUsername()+"', Name = '"+borrower.getName()+"', "
                    + "Surname = '"+borrower.getSurname()+"', Password = '"+borrower.getPassword()+"', "
                    + "PhoneNumber = '"+borrower.getPhoneNumber()+"', EmailAddress = '"+borrower.getEmailAddress()+"', "
                    + "WHERE Borrower_ID = '"+borrower.getUserID()+"';";
            database.con.createStatement().execute(query);
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("The data couldn't be updated to table Borrowers in database libraryManagementDB.");
        } 
    }
  
    public ArrayList<Book> getBooks(){
        return database.getBooks();
    }
    
    public Set<Borrower> getBorrowers(){
       return database.getBorrower();
    }
}
