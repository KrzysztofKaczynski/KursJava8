package interfacesAll;

import data.Book;

import java.util.function.BiPredicate;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class BiPredicateMain {


    public static void main(String[] args) {

        Book book1 = new Book(39.99, "Czysty kod", "twarda");
        Book book2 = new Book(29.99, "Pani jeziora", "twarda");

        BiPredicate<Book, Book> isMoreExpensive = (bookFirst, bookSecond) -> bookFirst.price > bookSecond.price;

        if (isMoreExpensive.test(book1, book2)) {
            System.out.println("Tak! Pierwsza książka jest droższa.");
        }

        BiPredicate<Book, Book> sameCover = (bookFirst, bookSecond) -> bookFirst.cover.equals(bookSecond.cover);

        if (sameCover.and(isMoreExpensive).test(book1, book2)) {
            System.out.println("Takie same okładki i książka pierwsza jest droższa.");
        }

        boolean i = isMoreExpensive.negate().test(book1, book2);
        System.out.println("Czy druga jest tańsza? " + i);


        boolean or = sameCover.or(isMoreExpensive).test(book1, book2);
        System.out.println("Jest droższa lub ta sama okładka? " + or);


    }
}
