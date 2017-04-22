package streams;

import data.Book;
import methodReference.BookCreator;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by davit.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class StreamMain {


  public static void main(String[] args) {
    //Wykorzystuję swój interfejs funkcjonalny do tworzenia książek
    BookCreator<Book> creatorNew = Book::new;
    Book book = creatorNew.create(11.99, "Bajki", "twarda");


    List<Book> list = Arrays.asList(
      creatorNew.create(39.99, "Czysty kod", "twarda"),
      creatorNew.create(49.99, "Pani jeziora", "miękka"),
      creatorNew.create(19.99, "PHP w akcji", "miękka"),
      creatorNew.create(29.99, "Bajki", "twarda"),
      creatorNew.create(19.99, "Żarty programistów", "miękka"));

    //Jak to było przed Java 8
    List<Book> filteredBook = new ArrayList<>();
    for (Book b : list) {
      if (b.price < 49.99) {
        filteredBook.add(b);
      }
    }

    Collections.sort(filteredBook, new Comparator<Book>() {
      @Override public int compare(Book o1, Book o2) {
        return Double.compare(o1.price, o2.price);
      }
    });

    List<String> namesBooks = new ArrayList<>();
    for (Book b : filteredBook) {
      namesBooks.add(b.title);
    }

    for (String b : namesBooks) {
      System.out.println(b);
    }


    //Jak to jest z Java 8


    List<String> titlesBooks = list.stream()
      .filter(b -> b.price < 49.99)
      .sorted(Comparator.comparing(Book::getPrice))
      .map(b -> b.getTitle()).collect(Collectors.toList());

    titlesBooks.forEach(b -> System.out.println(b));


  }
}
