package Model;

public class Borrower {
    
    private String username;
    private String name;
    private String surname;
    private String password;
    private String phone;
    private String email;
    
    public Borrower(String username, String name,String surname, String password, String phone, String email){
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }
    
    @Override
    public String toString(){
        return "Username: "+username
                +", Name: "+name
                +", Surname: "+surname
                +", Password: "+password
                +", Phone: "+phone
                +", Email: "+email;
    }
}
