package Library_Management_System;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", 5);
        library.addBook("1984", "George Orwell", 3);
        library.addBook("To Kill a Mockingbird", "Harper Lee", 4);
        
        library.addMember("Alice");
        library.addMember("Bob");

        while (true) {
            System.out.println("Welcome to the Library Management System");
            System.err.println("");
            System.out.println("Please select an option:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Show Available Books");
            System.out.println("4. Show Members");
            System.out.println("5. Borrow a Book");
            System.out.println("6. Return a Book");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book quantity: ");
                    int quantity = scanner.nextInt();
                    //1
                    //11
                    scanner.nextLine();
                    library.addBook(title, author, quantity);
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter member name: ");
                    String memberName = scanner.nextLine();
                    library.addMember(memberName);
                    System.out.println("Member added successfully.");
                    break;

                case 3:
                    library.showAvailableBooks();
                    break;

                case 4:
                    library.showMembers();
                    break;

                case 5:
                    System.out.print("Enter member name: ");
                    String borrowMemberName = scanner.nextLine();
                    System.out.print("Enter book title to borrow: ");
                    String borrowBookTitle = scanner.nextLine();
                    library.borrowBook(borrowMemberName, borrowBookTitle);
                    break;

                case 6:
                    System.out.print("Enter member name: ");
                    String returnMemberName = scanner.nextLine();
                    System.out.print("Enter book title to return: ");
                    String returnBookTitle = scanner.nextLine();
                    library.returnBook(returnMemberName, returnBookTitle);
                    break;

                case 7:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
