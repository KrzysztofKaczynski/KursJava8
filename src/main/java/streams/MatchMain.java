package streams;

import data.Book;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by zacznijprogramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class MatchMain {


    public static void main(String[] args) {
        List<Book> listBooks = Arrays.asList(
                new Book(39.99, "Czysty kod", "miękka", false),
                new Book(49.99, "Pani jeziora", "miękka", true),
                new Book(49.99, "Pani jeziora", "miękka", true),
                new Book(19.99, "PHP w akcji", "miękka", false),
                new Book(29.99, "Bajki", "miękka", true),
                new Book(19.99, "Żarty programistów", "miękka", true));

        boolean isPromotion = listBooks.stream().anyMatch(book -> book.isPromotion);
        System.out.println(isPromotion);

        boolean isLowerPrice = listBooks.stream().allMatch(book -> book.price < 39.00);
        System.out.println(isLowerPrice);

        boolean isHardCover = listBooks.stream().noneMatch(book -> book.cover.equals("twarda"));
        System.out.println(isHardCover);

    }
}