package org.example;

public class Book extends Item{

    private String author;
    private final int bookID;
    public Book(String title, String author){
        bookID = getUniqueID();
        setTitle(title);
        setAuthor(author);
    }
    @Override
    void borrowItem() {
        setBorrowed(true);
    }

    @Override
    void returnItem() {
        setBorrowed(false);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookID() {
        return bookID;
    }
}
