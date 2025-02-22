package LibraryManagementPackage;

class Adventure extends Book implements BookCategory {
    public Adventure(String bookTitle, String author) {
        super(bookTitle, author);
    }

    @Override
    public void borrow() {
        System.out.println("Borrowing an Adventure book: " + getTitle());
    }

    @Override
    public void displayCategory() {
        System.out.println("Category: Adventure");
    }
}
