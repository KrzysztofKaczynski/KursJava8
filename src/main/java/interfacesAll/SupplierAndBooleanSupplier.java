package interfacesAll;

import data.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class SupplierAndBooleanSupplier {

  public static void main(String[] args) {

    //Supplier
    List<Book> list = new ArrayList<>();

    Supplier<Book> supplier = Book::new;
    for (int i = 0; i < 100; i++) {
      list.add(supplier.get());
    }

    list.forEach(e -> System.out.println(e));
    //END Supplier


    //BooleanSupplier
    Book book = new Book(19.99, "Czysty kod", "twarda");

    BooleanSupplier booleanSupplier = () -> {
      Random random = new Random();
      return random.nextBoolean();
    };

    book.setPromotion(booleanSupplier.getAsBoolean());


    System.out.println(book.isPromotion);
    //END BooleanSupplier
  }
}
