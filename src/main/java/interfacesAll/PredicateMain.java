package interfacesAll;

import data.Book;

import java.util.function.Predicate;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class PredicateMain {



  public static void main(String[] args) {
    Book book = new Book(39.99, "twarda");
    Predicate<Book> checkPrice = book1 -> book1.price > 29.99;

    if (checkPrice.test(book)) {
      System.out.println("Drogo!");
    }

    Predicate<Book> checkCover = book2 -> book2.cover.equals("twarda");

    if (checkCover.and(checkPrice).test(book)) {
      System.out.println("Tanio!");
    }

    if (!checkPrice.negate().test(book)) {
      System.out.println("A jenak tanio!");
    }

    if (checkCover.or(checkPrice).test(book)) {
      System.out.println("Tanio lub drogo!");
    }

    Predicate<Book> i = Predicate.isEqual(new Book(39.99, "twarda"));
    System.out.println("Czy ta sama książka? " + i.test(book));

  }
}
