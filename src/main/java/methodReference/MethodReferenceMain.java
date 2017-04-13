package methodReference;

import data.Book;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class MethodReferenceMain {

  public static void main(String[] args) {

    //normalne stworzenie lambdy
    BookCreator<Book> creator = (a, b, c) -> new Book(11.99, "Bajki", "twarda");

    //referencja do konstruktora
    BookCreator<Book> creatorNew = Book::new;
    Book book = creatorNew.create(11.99, "Bajki", "twarda");


    List<Book> list = Arrays.asList(
      creatorNew.create(39.99, "Czysty kod", "twarda"),
      creatorNew.create(49.99, "Pani jeziora", "miękka"),
      creatorNew.create(19.99, "Hobbit","twarda"));


    //referencja do konstruktora
    list.sort(Comparator.comparing(Book::getPrice));

    //normalne stworzenie lambdy
    list.sort(Comparator.comparing(b -> book.getPrice()));

    Function<Book, String> consumer = c -> c.getTitle().toUpperCase();

    Function<String, String> consumerReference = String::toUpperCase;
    list.forEach(e -> System.out.println(consumerReference.apply(e.getTitle())));

  }

}
