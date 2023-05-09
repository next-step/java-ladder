package nextstep.fp;

import java.util.List;
import java.util.function.Predicate;

public class Lambda {
    public static void printAllOld(List<Integer> numbers) {
        System.out.println("printAllOld");

        numbers.forEach(System.out::println);
    }

    public static void printAllLambda(List<Integer> numbers) {
        System.out.println("printAllLambda");

        numbers.forEach(System.out::println);
    }

    public static void runInThread() {
        new Thread(() -> System.out.println("Hello from thread"))
                .start();
    }

    public static int sumAllNumbers(List<Integer> numbers) {
        return calculateSum(numbers, (number) -> true);
    }

    public static int sumAllEvenNumbers(List<Integer> numbers) {
        return calculateSum(numbers, (number) -> number % 2 == 0);
    }

    public static int sumAllGreaterThanThree(List<Integer> numbers) {
        return calculateSum(numbers, (number) -> number > 3);
    }

    private static int calculateSum(List<Integer> numbers, Predicate<Integer> filter) {
        return numbers.stream()
                .filter(filter)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
