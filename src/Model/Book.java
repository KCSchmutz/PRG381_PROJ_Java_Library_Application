package Model;

public class Book {
    private String bookID;
    private String bookTitle;
    private String authorName;
    private String authorSurname;
    private String borrowerUsername;
    private String condition; 
    
    public Book(String bookID, String bookTitle, String authorName, String authorSurname, String borrowerUsername, String condition){
        this.bookID = bookID; 
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.borrowerUsername = borrowerUsername;
        this.condition = condition;
    }
    
    public String getID(){
        return bookID;
    }    
    
    public String getTitle(){
        return bookTitle;
    }

    public String getAuthorName(){
        return authorName;
    }
    
    public String getAuthorSurname(){
        return authorSurname;
    }
    
    public String getBorrowerUsername(){
        return borrowerUsername;
    }

    public String getCondition(){
        return condition;
    }
    @Override
    public String toString(){
        return  "ID: " + bookID
                +", Title: "+bookTitle
                +", Author: "+authorName+" "+authorSurname
                +", Borrower's Username: "+ borrowerUsername
                +", Condition: " + condition;
    }
}
