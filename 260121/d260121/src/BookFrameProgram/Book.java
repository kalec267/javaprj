package BookFrameProgram;

import java.util.Collection;

public class Book {
    int id;
    String author, isbn, date;


    public Book(){

    }
    public Book(String author, String isbn, String date, int id) {
    }

    public Book(int id, String author, String isbn,String date) {
        this.id = id;
        this.author = author;
        this.isbn = isbn;
        this.date = date;
    }

    public Book(String author, String isbn, String date) {
        this.author = author;
        this.isbn = isbn;
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id +'\''+
                "author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public Collection<Object> getTitle() {
        return java.util.List.of();
    }
}
