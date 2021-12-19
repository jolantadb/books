package lv.sda.books;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class Bookstore {
    // saraksts ar grāmatam
    List<Book >books = new ArrayList<>();

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
                                LocalDate.of(Integer.parseInt(fields.get(6)), 1, 1)
                        );
                    })
                    .collect(toList());
            this.books.addAll(books);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBook (Book book){
//        pievieno grāmatu
    }

    public void removeBook (String isbn){
//        dzēš grāmatu pēc isbn
    }

    public Book getInfo(String isbn){
//        atrod grāmatu pēc isbn
        return null;
    }

    public List<Book>  searchBook(String query){
//        meklēt gramatas pēc query
        return emptyList();
    }

    public List<Book> allBooks(){
//        visas grāmatas
        return emptyList();
    }
}
