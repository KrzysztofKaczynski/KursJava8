package streams;

import data.Book;
import methodReference.BookCreator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by davit.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class FilterStreamMain {



    public static void main(String[] args) {
        //Wykorzystuję swój interfejs funkcjonalny do tworzenia książek
        BookCreator<Book> creatorNew = Book::new;

        List<Book> listBooks = Arrays.asList(
                new Book(39.99, "Czysty kod", "twarda", false),
                new Book(49.99, "Pani jeziora", "miękka", true),
                new Book(49.99, "Pani jeziora", "miękka", true),
                new Book(19.99, "PHP w akcji", "miękka", false),
                new Book(29.99, "Bajki", "twarda", true),
                new Book(19.99, "Żarty programistów", "miękka", true));


        listBooks.stream().filter(book -> book.isPromotion).forEach(book -> System.out.println(book));

        System.out.println("----");




        List<Book> newList = listBooks.stream()
                .filter(book -> book.isPromotion)
                .distinct()
                .limit(2)
                .skip(1)
                .collect(Collectors.toList());





        newList.forEach(book -> System.out.println(book));
    }
}
