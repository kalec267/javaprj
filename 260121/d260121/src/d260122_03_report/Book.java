package d260122_03_report;
//도서관리 프로그램
//Book 객체
//BookManager객체
//BookMain(main()으로 실행되는 함수 작성


public class Book {
    private String author, isbn, date;
    private int id;

    public Book(String author, String isbn, String date, int id) {
    }

    public Book(int id, String date, String isbn, String author) {
        this.id = id;
        this.date = date;
        this.isbn = isbn;
        this.author = author;
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
                ", id=" + id +
                "author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
