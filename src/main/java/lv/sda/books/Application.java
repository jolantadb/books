package lv.sda.books;

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
    static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {


        try {
            Path path = Paths.get("src/main/resources/books.txt");
            List<Book> books = Files.lines(path)
                    .map(line -> {
                        List<String> fields = Arrays.stream(line.split(";")).collect(toList());
                        return new Book(
                                fields.get(0),
                                fields.get(1),
                                fields.get(2),
                                fields.get(3),
                                fields.get(4),
                                Integer.parseInt(fields.get(5)),
                                LocalDate.of(Integer.parseInt(fields.get(6)), 1, 1)
                        );
                    })
                    .collect(toList());
            books.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean quit = false;

        while (!quit){
            System.out.println("\nEnter your choice: (0 to show available choices)");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    printChoices();
                    break;
                case 1:
                    System.out.println("Printing all books");
                    break;
                case 2:
                    System.out.println("Book info");
                    break;
                case 3:
                    System.out.println("Adding book");
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
