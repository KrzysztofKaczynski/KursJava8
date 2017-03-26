package interfacesAll;

import data.Book;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class ConsumerFunctionUnaryOperatorMain {

  public static void main(String[] args) {

    List<Book> list = Arrays.asList(
      new Book(19.99, "Czysty kod", "twarda"),
      new Book(29.99, "Pani jeziora", "miękka"),
      new Book(39.99, "Hobbit","twarda"));

    //Consumer
    Consumer<Book> printTitle = (book) -> System.out.println(book.title);
    list.forEach(printTitle);

    System.out.println();


    Consumer<Book> printCover = (book) -> System.out.println(book.cover);
    list.forEach(printTitle.andThen(printCover));
    //end Consumer


    //Function
    Book book1 = new Book(19.99, "Czysty kod", "twarda");
    Function<Book, String> returnPrice = (book) -> Double.toString(book.price);

    System.out.println(returnPrice.apply(book1));


    Function<String, String> addString = (s) -> "Cena: " +s;
    System.out.println(addString.compose(returnPrice).apply(book1));


    System.out.println(returnPrice.andThen(addString).apply(book1));


    Function<Book, Book> returnBook = Function.identity();
    Function<Book, Book> returnBook2 = book -> book;


    System.out.println(returnBook2.apply(book1));

    //end Function


    //UnaryOperator
    Book someBook = new Book(19.99, "Czysty kod", "twarda");
    UnaryOperator<Book> calculateDiscount = book -> book.clone();

    Book bookCopy = calculateDiscount.apply(someBook);
    System.out.println("Czy to te same obiekty? ");
    System.out.println(someBook == bookCopy);
    //end UnaryOperator
  }
}
