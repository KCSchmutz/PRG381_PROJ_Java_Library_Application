package Model;

public class Book {
    private String bookID;
    private String bookTitle;
    private String authorName;
    private String authorSurname;
    private String borrowerUsername;
    private String status;
    private String condition; 
    
    public Book(String bookID, String bookTitle, String authorName, String authorSurname, String borrowerUsername, String status, String condition){
        this.bookID = bookID; 
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.borrowerUsername = borrowerUsername;
        this.status = status;
        this.condition = condition;
    }
    
    public String getAuthor(){
        return authorName;
    }
    
    public String getTitle(){
        return bookTitle;
    }

    @Override
    public String toString(){
        return  "ID: " + bookID
                +", Title: "+bookTitle
                +", Author: "+authorName+" "+authorSurname
                +", Borrower's Username: "+ borrowerUsername
                +", Status: " + status
                +", Condition: " + condition;
    }
}
