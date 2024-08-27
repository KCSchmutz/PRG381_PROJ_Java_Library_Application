package Controller;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

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
}
