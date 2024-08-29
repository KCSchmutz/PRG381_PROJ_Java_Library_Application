package Model;

public class Borrower {
    private String userID;
    private String username;
    private String name;
    private String surname;
    private String password;
    private String phone;
    private String email;
    
    public Borrower(String userID, String username, String name,String surname, String password, String phone, String email){
        this.userID = userID;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }
    
    public String getUserID(){
        return userID;
    }
        
    public String getUsername(){
        return username;
    }
           
    public String getName(){
        return name;
    }
                
    public String getSurname(){
        return surname;
    }
        
    public String getPassword(){
        return password;
    }
    
    public String getPhoneNumber(){
        return phone;
    }
        
    public String getEmailAddress(){
        return email;
    }
    @Override
    public String toString(){
        return "UserID: " + userID
                +", Username: "+username
                +", Name: "+name
                +", Surname: "+surname
                +", Password: "+password
                +", Phone: "+phone
                +", Email: "+email;
    }
}
