package Library_Management_System;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> bookCatalog;
    private Map<String, Member> members;

    public Library() {
        bookCatalog = new HashMap<>();
        members = new HashMap<>();
    }

    public void addBook(String title, String author, int quantity) {
        Book book = new Book(title, author, quantity);
        bookCatalog.put(title, book);
    }

    public void addMember(String name) {
        Member member = new Member(name);
        members.put(name, member);
    }

    public boolean borrowBook(String memberName, String bookTitle) {
        Member member = members.get(memberName);
        Book book = bookCatalog.get(bookTitle);

        if (member == null) {
            System.out.println("Member not found.");
            return false;
        }

        if (book == null) {
            System.out.println("Book not available.");
            return false;
        }

        if (book.getQuantity() == 0) {
            System.out.println("Book is currently unavailable.");
            return false;
        }

        if (!member.borrowBook(book)) {
            System.out.println("Member cannot borrow more than 3 books.");
            return false;
        }

        book.decreaseQuantity();
        System.out.println(memberName + " borrowed " + bookTitle);
        return true;
    }

    public boolean returnBook(String memberName, String bookTitle) {
        Member member = members.get(memberName);
        Book book = bookCatalog.get(bookTitle);

        if (member == null) {
            System.out.println("Member not found.");
            return false;
        }

        if (book == null) {
            System.out.println("Book not available.");
            return false;
        }

        if (!member.returnBook(book)) {
            System.out.println("This book was not borrowed by the member.");
            return false;
        }

        book.increaseQuantity();
        System.out.println(memberName + " returned " + bookTitle);
        return true;
    }

    public void showAvailableBooks() {
        System.out.println("\nAvailable books in the library:");
        for (Book book : bookCatalog.values()) {
            System.out.println(book);
        }
    }

    public void showMembers() {
        System.out.println("\nLibrary Members:");
        for (Member member : members.values()) {
            System.out.println(member);
        }
    }
}
