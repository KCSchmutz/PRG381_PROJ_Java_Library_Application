package Controller;

import Model.Book;
import Model.Borrower;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashSet;
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
    
    public ArrayList<Book> getSearchedBooks(String data, String method){
        ArrayList<Book> books = new ArrayList<Book>();
        String query="SELECT * FROM Books WHERE '";
        String[] selector= new String[2];
        selector[0]=""; 
        selector[1]="";
        String dataOne="";
        String dataTwo="";
        switch(method){
            case "ISBN":
                selector[0] = "BookSerial_ID";
                break;
            case "Title":
                selector[0] = "BookName";
                break;
            case "Author":
                selector[0] = "AuthorName";
                selector[1] = "AuthorSurname";
                break;
            case "Condition":
                selector[0] = "Condition";
                break;
            case "BorrowerUsername":
                selector[0] = "BorrowerUsername";
                break;     
        }
        if(selector[1].equals("")){
            query += selector[0]+"' = '"+data+"'";
        }else{
            dataOne = data.split(" ")[0];
            dataTwo = data.split(" ")[1];
            query += selector[0]+"' = '"+data+"' AND";
            query += selector[0]+"' = '"+data+"'";
        }
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

    public Set<Borrower> getSearchedBorrowers(String data, String method){
        Set<Borrower> borrowers = new HashSet<>();
        String query="SELECT * FROM Borrowers WHERE '";
        String selector = "";
        switch(method){
            case "Username":
                selector = "Username";
                break;
            case "Name":
                selector = "Name";
                break;
            case "Surname":
                selector = "Surname";
                break;
            case "Phone Num":
                selector = "PhoneNumber";
                break;
            case "Email":
                selector = "EmailAddress";
                break;     
        }
        query += selector+"' = '"+data+"'";
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

    public Set<Borrower> getBorrower(){
        Set<Borrower> borrowers = new HashSet<>();
        String query= "SELECT * FROM Borrowers";
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
