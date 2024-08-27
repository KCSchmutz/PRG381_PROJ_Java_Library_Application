/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.SQLException;
/**
 *
 * @author wasch
 */
public class DBController {
    private DBConnection database;
    
    public DBController() throws ClassNotFoundException{
        this.database.connect();
    }
    
    public void createBooksTable(){
        try{
            String query = "Create Table Books(BookSerial_ID varchar(20), BookName varchar(20), "
                    + "AuthorName varchar(20), AuthorSurname varchar(20), "
                    + "BorrowerUsername varchar(20), Status varchar(20), "
                    + "Condition varchar(20) )";
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
    
    public void addBook(String bookSerial_ID, String bookName, String Author ){
        
    }
}
