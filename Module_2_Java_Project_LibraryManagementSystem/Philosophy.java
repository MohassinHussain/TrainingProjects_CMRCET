package LibraryManagementPackage;

class Philosophy extends Book {
    public Philosophy(String bookTitle, String author) {
        super(bookTitle, author);
    }
    public void borrow() {
        System.out.println("Borrowing a Programming book.");
    }
}