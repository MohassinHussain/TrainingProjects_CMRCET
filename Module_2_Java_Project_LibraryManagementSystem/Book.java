package LibraryManagementPackage;

abstract class Book {
    private String bookTitle, author;
    public Book(String bookTitle, String author) {
        this.bookTitle = bookTitle;
        this.author = author;
    }
    public String getTitle() {
        return bookTitle;
    }
    public String getAuthor() {
        return author;
    }
    public abstract void borrow();
}
