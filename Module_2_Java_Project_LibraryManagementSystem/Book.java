package LibraryManagementPackage;

class Book {
    private String bookTitle, author;
    Book(String bookTitle, String author) {
        this.bookTitle = bookTitle;
        this.author = author;
    }
    public String getTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return author;
    }
    public void borrow() {
        System.out.println("Borrowing the book...");
    }
}


