package lv.sda.books;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

public class Bookstore {
    // saraksts ar grāmatam


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
