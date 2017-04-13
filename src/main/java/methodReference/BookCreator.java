package methodReference;

/**
 * Created by davit.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
@FunctionalInterface
public interface BookCreator<Book> {

  Book create(double price, String title, String cover);
}
