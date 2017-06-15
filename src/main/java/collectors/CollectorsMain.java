package collectors;

import data.Book;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.sun.tools.javac.util.List.of;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class CollectorsMain {

    public static void main(String[] args) {

        Book[] tableBook = {new Book(19.99, "Czysty kod", "twarda"),
                new Book(29.99, "Pani jeziora", "miękka"),
                new Book(39.99, "Hobbit", "twarda")};

        List<Book> listBook = Stream.of(tableBook).collect(Collectors.toList());

        Map<String, Book> mapBook = Stream.of(tableBook).collect(Collectors.toMap(book -> book.getTitle(), book -> book));

        Set<Book> setBook = Stream.of(tableBook).collect(Collectors.toSet());

        Collection<Book> linkedList = Stream.of(tableBook).collect(Collectors.toCollection(LinkedList::new));

        String titles = Stream.of(tableBook).map(e -> e.getTitle()).collect(Collectors.joining(", "));
        System.out.println(titles); //wynik: Czysty kod, Pani jeziora, Hobbit


        Long countBook = Stream.of(tableBook).collect(Collectors.counting());
        System.out.println(countBook);

        DoubleSummaryStatistics summarizingPrice = Stream.of(tableBook).collect(Collectors.summarizingDouble(book -> book.getPrice()));
        System.out.println(summarizingPrice.getAverage()); //wynik:  29.99
        System.out.println(summarizingPrice.getCount()); //wynik:  3
        System.out.println(summarizingPrice.getMax()); //wynik:  39.99
        System.out.println(summarizingPrice.getMin()); //wynik:  19.99
        System.out.println(summarizingPrice.getSum()); //wynik: 89.97

        Map<Double, List<Book>> listPrice = Stream.of(tableBook).collect(Collectors.groupingBy(book -> book.getPrice(), toList()));
    }
}
