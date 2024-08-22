/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author wasch
 */
public class Book {
    private String authorName;
    private String bookTitle;
    
    public String getAuthor(){
        return authorName;
    }
    
    public String getTitle(){
        return bookTitle;
    }
    
    public Book(String author, String book){
        this.authorName = author;
        this.bookTitle = book;
    }
    
    @Override
    public String toString(){
        return "Title: "+bookTitle+", Author: "+authorName;
    }
}
