package LibraryManagementPackage;

import java.util.InputMismatchException;
import java.util.Scanner;

class BorrowBook extends Thread {
    private Member member;
    private Book book;
    private Scanner sc;

    public BorrowBook(Member member, Book book, Scanner sc) {
        this.member = member;
        this.book = book;
        this.sc = sc;
    }

    @Override
    public void run() {
        try {
            System.out.print("Enter borrow date: ");
            if (!sc.hasNextInt()) {
                throw new InputMismatchException("Invalid input! Please enter a valid number.");
            }
            int borrowDate = sc.nextInt();
            sc.nextLine(); // Consume newline
            member.borrowBook(book);
            System.out.println("---- THANK YOU ----");
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            sc.nextLine(); // Clear the buffer
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

class ReturnBook extends Thread {
    private Member member;
    private Book book;
    private int borrowDate;
    private Scanner sc;

    public ReturnBook(Member member, Book book, int borrowDate, Scanner sc) {
        this.member = member;
        this.book = book;
        this.borrowDate = borrowDate;
        this.sc = sc;
    }

    @Override
    public void run() {
        try {
            System.out.print("Enter return date: ");
            if (!sc.hasNextInt()) {
                throw new InputMismatchException("Invalid input! Please enter a valid number.");
            }
            int returnDate = sc.nextInt();
            sc.nextLine(); // Consume newline
            if (returnDate > borrowDate + 30) {
                System.out.println("Late return! Pay a fine.");
            } else {
                member.returnBook(book);
            }
            System.out.println("---- THANK YOU ----");
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            sc.nextLine(); // Clear the buffer
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Welcome to the Library Management System!");
            System.out.print("Enter book title: ");
            String bookTitle = sc.nextLine();
            System.out.print("Enter Author name: ");
            String authorName = sc.nextLine();

            Book book = new Adventure(bookTitle, authorName);
            Librarian librarian = new Librarian("Sam", "lib1");
            librarian.addBook(book);

            System.out.print("Enter your name: ");
            String memberName = sc.nextLine();
            System.out.print("Enter your Id: ");
            String memId = sc.nextLine();
            Member member = new Member(memberName, memId);

            System.out.println("1. Borrow Book\n2. Return Book\n3. Exit");
            if (!sc.hasNextInt()) {
                throw new InputMismatchException("Invalid option! Choose 1, 2, or 3.");
            }
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    BorrowBook borrowThread = new BorrowBook(member, book, sc);
                    borrowThread.start();
                    borrowThread.join(); // Ensure thread execution completes
                    break;
                case 2:
                    System.out.print("Enter borrow date: ");
                    if (!sc.hasNextInt()) {
                        throw new InputMismatchException("Invalid input! Please enter a valid number.");
                    }
                    int borrowDate = sc.nextInt();
                    sc.nextLine();
                    ReturnBook returnThread = new ReturnBook(member, book, borrowDate, sc);
                    returnThread.start();
                    returnThread.join(); // Ensure thread execution completes
                    break;
                case 3:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid option! Choose 1, 2, or 3.");
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
