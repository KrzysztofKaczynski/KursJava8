package streams;

import data.Book;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by zacznijprogramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class FindAnyFindFirstMain {

  public static void main(String[] args) throws NotFound {
    List<Book> listBooks = Arrays.asList(
      new Book(39.99, "Czysty kod", "twarda", false),
      new Book(49.99, "Pani jeziora", "miękka", false),
      new Book(19.99, "PHP w akcji", "miękka", true),
      new Book(29.99, "Bajki", "twarda", false),
      new Book(19.99, "Żarty programistów", "miękka", true));

    Optional<Book> optional = listBooks.stream().filter(Book::isPromotion).findFirst();
    System.out.println(optional);

    //sprawdza czy obiekt istnieje
    boolean isBook = optional.isPresent();

    //sprawdza czy istnieje i zmienia jego wartosc
    optional.ifPresent(book -> book.setPromotion(false));

    //pobiera obiekt
    Book book = optional.get();

    //zwraca wartość jeżeli jest, jeżeli nie tworzy nową
    Book newBook = optional.orElse(new Book(9.99, "Nowa książka w promocji", "miękka", true));

    //Jeżeli nie ma wyniku, możemy rzucić wyjątek
    Book bookOrException = optional.orElseThrow(NotFound::new);

  }

}
