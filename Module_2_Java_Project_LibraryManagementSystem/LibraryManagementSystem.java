package LibraryManagementPackage;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to Library management System..");
            System.out.println("--------");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter book title: ");
            String bookTitle = sc.nextLine();
            System.out.print("Enter Author name: ");
            String authorName = sc.nextLine();

            Book b1 = new Adventure(bookTitle, authorName);
//        Book b2 = new Programming("The Pragmatic Programming", "Dave Thomas");
//        Book b3 = new Philosophy("Think and grow rich", "Napolean");

            Librarian lib = new Librarian("Sam", "lib1");
            lib.addBook(b1);
//        lib.addBook(b2);
//        lib.addBook(b3);
            System.out.println("--------");
            System.out.println("Enter details below to borrow or return the book..");
            System.out.print("Enter your name: ");
            String memberName = sc.nextLine();
            System.out.print("Enter your Id: ");
            String memId = sc.nextLine();
            Member mem = new Member(memberName, memId);

            System.out.println("1. Borrow book\n2. Return book\n3. Exit");
            int borrowDate = 0, returnDate;
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter borrow date: ");
                    borrowDate = sc.nextInt();

                    System.out.print(mem.getMemberName() + " ");
                    mem.borrowBook(b1);
                    System.out.println("----THANK YOU----");
                    break;
                case 2:
                    System.out.print("Enter date taken: ");
                    returnDate = sc.nextInt();
                    if(returnDate > (borrowDate + 30)) {
                        System.out.println("Pay Fine accordingly..");
                        System.out.println("----THANK YOU----");
                        return;
                    }
                    else {
                        System.out.print(mem.getMemberName() + " ");
                        mem.returnBook(b1);
                        System.out.println("----THANK YOU----");
                    }
                    break;
                case 3:
                    return;
            }
        }

    }
}