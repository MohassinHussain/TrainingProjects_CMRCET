package LibraryManagementPackage;

class Programming extends Book implements BookCategory {
    public Programming(String bookTitle, String author) {
        super(bookTitle, author);
    }

    @Override
    public void borrow() {
        System.out.println("Borrowing a Programming book: " + getTitle());
    }

    @Override
    public void displayCategory() {
        System.out.println("Category: Programming");
    }
}
