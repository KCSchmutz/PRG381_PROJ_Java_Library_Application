package Model;

public class Book {
    private String authorName;
    private String bookTitle;
    
    public Book(String authorName,String bookTitle){
        this.authorName = authorName;
        this.bookTitle = bookTitle;   
    }
    
    public String getAuthor(){
        return authorName;
    }
    
    public String getTitle(){
        return bookTitle;
    }
        
    @Override
    public String toString(){
        return "Title: "+bookTitle+", Author: "+authorName;
    }
}
