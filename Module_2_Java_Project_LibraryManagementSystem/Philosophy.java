package LibraryManagementPackage;

class Philosophy extends Book implements BookCategory {
    public Philosophy(String bookTitle, String author) {
        super(bookTitle, author);
    }

    @Override
    public void borrow() {
        System.out.println("Borrowing a Philosophy book: " + getTitle());
    }

    @Override
    public void displayCategory() {
        System.out.println("Category: Philosophy");
    }
}
