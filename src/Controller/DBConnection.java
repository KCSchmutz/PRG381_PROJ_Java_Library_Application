package Controller;

import Model.Book;
import Model.Borrower;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.Set;
public class DBConnection {
    
    //Importing Apache Derby driver...
    private static final String DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL="jdbc:derby:libraryManagementDB; create=true";
    
    public Connection con;
    
    public DBConnection(){
    }
    
    public void connect() throws ClassNotFoundException{
        try {
            Class.forName(DRIVER);
            this.con = (Connection) DriverManager.getConnection(JDBC_URL);
            if(this.con != null){
               System.out.println("Connected to database");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    } 

    public ArrayList<Book> getBooks(){
        ArrayList<Book> books = new ArrayList<Book>();
        String query= "SELECT * FROM Books";
        try(Connection conn = DriverManager.getConnection(JDBC_URL);
        PreparedStatement preState = conn.prepareStatement(query);
        ResultSet rs = preState.executeQuery()){
            while(rs.next()){
                books.add(new Book(rs.getString("BookSerial_ID"),rs.getString("BookName"),
                rs.getString("AuthorName"),rs.getString("AuthorSurname"),rs.getString("BorrowerUsername"),
                rs.getString("Condition")));
            }
            return books;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
        

    public Set<Borrower> getBorrower(){
        Set<Borrower> borrowers = null;
        String query= "SELECT * FROM Borrower";
        try(Connection conn = DriverManager.getConnection(JDBC_URL);
        PreparedStatement preState = conn.prepareStatement(query);
        ResultSet rs = preState.executeQuery()){
            while(rs.next()){
                borrowers.add(new Borrower(rs.getString("Borrower_ID"),rs.getString("Username"),
                rs.getString("Name"),rs.getString("Surname"),rs.getString("Password"),
                rs.getString("PhoneNumber"),rs.getString("EmailAddress")));
            }
            return borrowers;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
