package nextstep.fp;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Lambda {

    private Lambda() {
    }

    public static void printAllOld(List<Integer> numbers) {
        System.out.println("printAllOld");

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static void printAllLambda(List<Integer> numbers) {
        System.out.println("printAllLambda");

        numbers.forEach(System.out::println);
    }

    public static void runThread() {
        new Thread(() -> System.out.println("Hello from thread")).start();
    }

    public static int sumAll(List<Integer> numbers) {
        return numbers.stream()
                      .flatMapToInt(IntStream::of)
                      .sum();
    }

    public static int sumAll(List<Integer> numbers, Conditional c) {
        return numbers.stream()
                      .filter(c::test)
                      .collect(collectingAndThen(toList(), Lambda::sumAll));
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumAll(numbers, n -> n % 2 == 0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumAll(numbers, n -> n > 3);
    }
}
