package lv.sda.books;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;


public class Bookstore {
    // List of books
    List<Book> books = new ArrayList<>();

    public Bookstore() {
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
                                Integer.parseInt(fields.get(6)));
                    })
                    .collect(toList());
            this.books.addAll(books);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Adding book
    public void addNewBook(Book book) {
        boolean foundBook = false;
        for (Book value : this.books) {
            if (foundBook) break;
            if (value.getIsbn().equals(book.getIsbn())) {
                foundBook = true;
            }
        }
        if (foundBook) {
            System.out.println("This book is already in store!");
        } else {
            books.add(book);
            System.out.println("This book is ADDED to the store!");
        }
    }

    //    Removing book
    public void removeBook(String isbn) {
        var done = 0;
        for (int i = 0; i < this.books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                books.remove(i);
                done++;
            }
        }
        if (done == 0) {
            System.out.println("Book with this ISBN - " + isbn + " - is NOT found!");
        } else if (done != 0) {
            System.out.println("Book is REMOVED from the store!");
        }
    }

    //Get book info
    public Book getInfo(String isbn) {
        var done = 0;
        for (Book book : this.books) {
            if (book.getIsbn().equals(isbn)) {
                System.out.println(
                        "Title ---> " + book.getTitle() +
                                " \nAuthor ---> " + book.getAuthor() +
                                " \nDescription ---> " + book.getDescription() +
                                " \nPublishing year ---> " + book.getPublishingYear() +
                                " \nPublisher ---> " + book.getPublisher() +
                                " \nNumber of pages ---> " + book.getPages());
                done++;
            }
        }
        if (done == 0) {
            System.out.println("Book with this ISBN - " + isbn + " - is NOT found!");
        }
        return null;
    }

    public void searchBookByAuthor(String author) {
        var done = 0;
        for (Book book : this.books) {
            if (book.getAuthor().equals(author)) {
                System.out.println();
            } else {
                System.out.println("Book NOT found!");
            }
        }

    }

    public void printAllBooks() {
        System.out.println("Printing all books: ");
        for (int i = 0; i < this.books.size(); i++) {
            System.out.println((i + 1) + "." +
                    this.books.get(i).getIsbn() + " - " +
                    this.books.get(i).getTitle() + " - " +
                    this.books.get(i).getAuthor() + " - " +
                    this.books.get(i).getDescription());
        }
    }

    public void saveToFile() {
        try {
            Path file = Paths.get("src/main/resources/books.txt");
            List<String> lines = books.stream().map(Book::toString).collect(toList());
            Files.write(file, lines);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
