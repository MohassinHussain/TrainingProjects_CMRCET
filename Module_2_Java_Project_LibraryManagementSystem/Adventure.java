package LibraryManagementPackage;

class Adventure extends Book {
    public Adventure(String bookTitle, String author) {
        super(bookTitle, author);
    }

    public void borrow() {
        System.out.println("Borrowing a Adventure book.");
    }
}