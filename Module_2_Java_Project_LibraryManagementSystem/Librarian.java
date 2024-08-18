package LibraryManagementPackage;

class Librarian {
    private String name, id;
    public Librarian(String name, String id) {
        this.name = name;
        this.id = id;
    }

    //    librarian can add book can remove
    public void addBook(Book book){
        System.out.println("You have  added book: " + book.getTitle() + " by " + book.getAuthor() + " to operations List.");
    }
    public void removeBook(Book book){
        System.out.println("Removed book: " + book.getTitle());
    }

}
