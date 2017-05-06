package streams;

import data.Book;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by davit.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class MapFlatMapStreamMain {

    public static void main(String[] args) {
        List<Book> listBooks = Arrays.asList(
                new Book(39.99, "Czysty kod", "twarda", false),
                new Book(49.99, "Pani jeziora", "miękka", true),
                new Book(49.99, "Pani jeziora", "miękka", true),
                new Book(19.99, "PHP w akcji", "miękka", false),
                new Book(29.99, "Bajki", "twarda", true),
                new Book(19.99, "Żarty programistów", "miękka", true));


        List<Double> pricesList = listBooks.stream()
                .map(Book::getPrice)
                .collect(Collectors.toList());


        List<String> pricesListString = listBooks.stream()
                .map(Book::getPrice)
                .map(String::valueOf)
                .collect(Collectors.toList());


        //nowa lista
        List<Book> listBooks2 = Arrays.asList(
                new Book(39.99, "Czysty kod", "twarda", false),
                new Book(49.99, "Pani jeziora", "miękka", true),
                new Book(49.99, "Pani jeziora", "miękka", true));

        //lista z listami książek
        List<List<Book>> collectionOListBooks = Arrays.asList(listBooks, listBooks2);

        //Na tym uzyjemy flat map
        Stream<List<Book>> streamOfListBooks = collectionOListBooks.stream();

        List<Book> uniqueListOfBooks = streamOfListBooks.flatMap(books -> books.stream()).distinct().collect(Collectors.toList());


        System.out.println("Unikalna lista");

        uniqueListOfBooks.forEach(book -> {
            System.out.println(book);
        });


        List<Book> selectedList = collectionOListBooks.stream()
                .flatMap(books -> books.stream())
                .distinct()
                .collect(Collectors.toList());


    }


}
