package lambdaScope;

import data.Book;

import java.util.function.Predicate;

/**
 * Created by davit.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class ScopeMain {


  public static void main(String[] args) {
    TestLambdaScope scopeMain = new TestLambdaScope();
    scopeMain.checkPrice();

  }


  static class TestLambdaScope {
    Book book = new Book(29.99, "Pani jeziora", "miękka");
    double maxPrice = 30.0;

    public void checkPrice() {
      Predicate<Book> checkPriceBook = book -> {
        maxPrice = 19.99;
        return book.price > maxPrice;
      };

      System.out.println(checkPriceBook.test(book));
    }

    public void checkPriceFinal() {
      final double maxPriceFinal = 39.99;
      Predicate<Book> checkPriceBook = book -> {
        return book.price > maxPrice;
      };

      System.out.println(checkPriceBook.test(book));
    }

  }

}
