package interfacesAll;

import java.util.function.*;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class Others {


  public static void main(String[] args) {

    ObjDoubleConsumer<String> objDoubleConsumer = (s, d) -> System.out.println(s + d);
    objDoubleConsumer.accept("PI równa się: ", 3.14);

    ObjIntConsumer<Double> doubleObjIntConsumer = (d, i) -> System.out.println("I tak jestem PI: " + (i + d));
    doubleObjIntConsumer.accept(0.14, 3);

    ObjLongConsumer<String> stringObjLongConsumer = (s, d) -> System.out.println(s + d);
    stringObjLongConsumer.accept("Jestem najdłuższą liczbą świata!: ", Long.MAX_VALUE);

    ToDoubleBiFunction<Integer, Integer> toDoubleBiFunction = (x, y) -> (x + y) / 3.14;
    System.out.println(toDoubleBiFunction.applyAsDouble(2, 3));

    ToDoubleFunction<String> toDoubleFunction = (x) -> Double.valueOf(x);
    System.out.println(toDoubleFunction.applyAsDouble("3.14"));

    DoubleBinaryOperator doubleBinaryOperator = (x, y) -> x + y;
    System.out.println(doubleBinaryOperator.applyAsDouble(3.0, 0.14));

    DoubleConsumer doubleConsumer = x -> System.out.println(x + 3.0);
    doubleConsumer.accept(0.14);

    DoubleFunction<String> doubleFunction = x -> "Jestem stringiem PI: " + x;
    System.out.println(doubleFunction.apply(3.14));

    DoublePredicate doublePredicate = x -> x > 3.14;
    System.out.println("Czy jestem większa od PI? " + doublePredicate.test(2.14));

    DoubleSupplier doubleSupplier = () -> 3.14;
    System.out.println("Dostarczam PI: " + doubleSupplier.getAsDouble());

    DoubleToIntFunction doubleToIntFunction = x -> (int) Math.round(x);
    System.out.println("Jestem okrągłe PI: " + doubleToIntFunction.applyAsInt(3.14));

    DoubleToLongFunction doubleToLongFunction = x -> Math.round(x);
    System.out.println("Jestem okrągłe PI jako long: " + doubleToLongFunction.applyAsLong(3.14));

    DoubleUnaryOperator doubleUnaryOperator = x -> x*2;
    System.out.println("Jestem podwojone PI: " + doubleUnaryOperator.applyAsDouble(3.14));
  }
}
