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
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Application {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Bookstore bookstore = new Bookstore();

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
                    System.out.println("Printing all books");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Book info");
                    break;
                case 3:
                    System.out.println("Adding book");
                    try {
                        FileWriter myW = new FileWriter("src/main/resources/books.txt", true);
                        BufferedWriter out = new BufferedWriter(myW);
                        System.out.println("write: isbn;title;author;publisher;description;pages;publishing year");
                        out.write("\n");
                        out.write(scanner.nextLine());
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case 4:
                    System.out.println("Removing book");
                    break;
                case 5:
                    System.out.println("Searching book");
                    break;
                case 6:
                    System.out.println("Author information");
                    break;
                case 7:
                    System.out.println("\n You quited the store!");
                    quit = true;
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

}
