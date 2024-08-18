package LibraryManagementPackage;

class Programming extends Book {
    public Programming(String bookTitle, String author) {
        super(bookTitle, author);
    }

    public void borrow() {
        System.out.println("Borrowing a Programming book.");
    }
}
