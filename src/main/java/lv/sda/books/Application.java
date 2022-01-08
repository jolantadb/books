package lv.sda.books;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Application {
    static Scanner scanner = new Scanner(System.in);
    private static Bookstore bookstore = new Bookstore();

    public static void main(String[] args) {

        boolean quit = false;

        while (!quit) {
            System.out.println("\nEnter your choice: (0 to show available choices)");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printChoices();
                    break;

                case 1:
                    bookstore.printAllBooks();
                    break;

                case 2:
                    getBookInfo();
                    break;

                case 3:
                    System.out.println("Adding book :");
                    addNewBook();
                    break;

                case 4:
                    removeBookByIsbn();
                    break;

                case 5:
                    searchByAuthor();
                    break;

                case 6:
                    System.out.println("Author information: ");
                    break;

                case 7:
                    System.out.println("\n You quited the store!");
                    quit = true;
//                    bookstore.saveToFile();
                    break;
            }
        }
    }


    private static void printChoices() {
        System.out.println("\nAvailable choices:\npress");
        System.out.println("0  - to print a list of available choices\n" +
                "1  - to print all books\n" +
                "2  - to get book info by isbn\n" +
                "3  - to add a new book\n" +
                "4  - to remove an existing book by isbn\n" +
                "5  - to search a book by query\n" +
                "6  - to print author information\n" +
                "7  - to quit\n");
        System.out.println("Choose your action: ");
    }

    private static void addNewBook() {

        Book newBook = new Book();

        System.out.println("Enter isbn");
        String isbn = scanner.nextLine();
        newBook.setIsbn(isbn);

        System.out.println("Enter title");
        String title = scanner.nextLine();
        newBook.setTitle(title);

        System.out.println("Enter author");
        String author = scanner.nextLine();
        newBook.setAuthor(author);

        System.out.println("Enter publisher");
        String publisher = scanner.nextLine();
        newBook.setPublisher(publisher);

        System.out.println("Enter description");
        String description = scanner.nextLine();
        newBook.setDescription(description);

        System.out.println("Enter number of pages");
        int pages = scanner.nextInt();
        newBook.setPages(pages);

        System.out.println("Enter the release year");
        int publishingYear = scanner.nextInt(3);
        newBook.setPublishingYear(publishingYear);

        bookstore.addNewBook(newBook);

//            if (bookstore.addNewBook(newBook)) {
//                System.out.println("New book added: " + title + " - " + author);
//
//            } else {
//                System.out.println("This book is already in store! ");
//            }

    }

    private static void searchByAuthor() {
        System.out.println("Enter the name of the author: ");
        String author = scanner.nextLine();
        bookstore.searchBookByAuthor(author);
    }

    private static void removeBookByIsbn() {
        System.out.println("Enter the book ISBN you want to remove: ");
        String isbn = scanner.nextLine();
        bookstore.removeBook(isbn);
    }

    private static void getBookInfo() {
        System.out.println("Enter the book ISBN: ");
        String isbn = scanner.nextLine();
        bookstore.getInfo(isbn);
    }

}

