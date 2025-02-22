package LibraryManagementPackage;

class Librarian {
    private String name, id;

    public Librarian(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void addBook(Book book) {
        System.out.println("Book added: " + book.getTitle() + " by " + book.getAuthor());
    }

    public void removeBook(Book book) {
        System.out.println("Book removed: " + book.getTitle());
    }
}
