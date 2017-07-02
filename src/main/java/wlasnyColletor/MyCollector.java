package wlasnyColletor;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */


class MyCollector {
    public static void main(String[] args) {
        List<String> stringNumbers = Arrays.asList("1", "2", "3", "4", "5", "7", "8", "9");
        List<Integer> integerList = stringNumbers.stream().collect(new IntegerCollector());
        integerList.forEach(i -> System.out.print(i));
    }
}


class IntegerCollector implements Collector<String, List<String>, List<Integer>> {

    //tworzymy strukturę akumulatora
    @Override
    public Supplier<List<String>> supplier() {
        return ArrayList::new;
    }

    //dodajemy elementy do akumulatora
    @Override
    public BiConsumer<List<String>, String> accumulator() {
        return (accumulator, element) -> accumulator.add(element);
    }

    //w przypadku wielowątkowosci musimy połaczyć akumulatory
    @Override
    public BinaryOperator<List<String>> combiner() {
        return (accumulator1, accumulator2) -> {
            accumulator1.addAll(accumulator2);
            return accumulator1;
        };
    }

    //przetwarzamy akumulator na ostateczną wersję naszaego typu kolektora
    @Override
    public Function<List<String>, List<Integer>> finisher() {
        return (accumulator) -> {
            Function.identity();
            return accumulator.stream().map(Integer::parseInt).collect(Collectors.toList());
        };
    }

    //konfiguracja kolektora
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.CONCURRENT));
    }
}
