package LibraryManagementPackage;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Welcome to Library management System..");
                System.out.println("--------");
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter book details to add to library");
                System.out.print("Enter book title: ");
                String bookTitle = sc.nextLine();
                System.out.print("Enter Author name: ");
                String authorName = sc.nextLine();

                Book b1 = new Adventure(bookTitle, authorName);

                // Book objects can be added here
                // Book b2 = new Programming("The Pragmatic Programming", "Dave Thomas");
                // Book b3 = new Philosophy("Think and grow rich", "Napolean");

                Librarian lib = new Librarian("Sam", "lib1");
                lib.addBook(b1);

                System.out.println("--------");
                System.out.println("Enter details below to borrow or return the book..");
                System.out.print("Enter your name: ");
                String memberName = sc.nextLine();
                System.out.print("Enter your Id: ");
                String memId = sc.nextLine();
                Member mem = new Member(memberName, memId);

                System.out.println("1. Borrow book\n2. Return book\n3. Exit");

                int borrowDate = 0, returnDate;
                int choice = 0;

                try {
                    choice = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter a valid number (1, 2 or 3).");
                    sc.nextLine();
                    continue;
                }

                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter borrow date: ");
                            borrowDate = sc.nextInt();
                            System.out.print(mem.getMemberName() + " ");
                            mem.borrowBook(b1);
                            System.out.println("----THANK YOU----");
                        } catch (Exception e) {
                            System.out.println("Invalid input for borrow date! Please enter a valid number.");
                            sc.nextLine();
                        }
                        break;
                    case 2:
                        try {
                            System.out.print("Enter date taken: ");
                            returnDate = sc.nextInt();
                            if (returnDate > (borrowDate + 30)) {
                                System.out.println("Pay Fine accordingly..");
                                System.out.println("----THANK YOU----");
                                return;
                            } else {
                                System.out.print(mem.getMemberName() + " ");
                                mem.returnBook(b1);
                                System.out.println("----THANK YOU----");
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input for return date! Please enter a valid number.");
                            sc.nextLine();
                        }
                        break;
                    case 3:
                        System.out.println("Exiting the system...");
                        return;
                    default:
                        System.out.println("Invalid option! Please choose a valid option (1, 2, or 3).");
                        break;
                }
            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
                e.printStackTrace();
            }
        }
    }
}
