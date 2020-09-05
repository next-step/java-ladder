package nextstep.fp;

import java.util.List;
import java.util.function.Predicate;

public class Lambda {

    private static final int DEFAULT_SUM = 0;

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
        return sumAllConditionally(numbers, number -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumAllConditionally(numbers, number -> number % 2 == 0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumAllConditionally(numbers, number -> number > 3);
    }

    private static int sumAllConditionally(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .filter(predicate)
                .reduce(Integer::sum)
                .orElse(DEFAULT_SUM);
    }
}
