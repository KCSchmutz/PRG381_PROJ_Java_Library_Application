package Model;

public class Book {
    private String authorName;
    private String bookTitle;
    private String bookID;
    private String status;
    private String condition; 
    
    public Book(String authorName,String bookTitle, String bookID, String status, String condition){
        this.authorName = authorName;
        this.bookTitle = bookTitle;
        this.bookID = bookID;
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
                +", Author: "+authorName
                +", Status: " + status
                +", Condition: " + condition;
    }
}
