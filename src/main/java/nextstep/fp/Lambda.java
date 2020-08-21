package nextstep.fp;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Lambda  {
    public static void printAllOld(List<Integer> numbers) {
        printNumbers("printAllOld", numbers, System.out::println);
    }

    public static void printAllLambda(List<Integer> numbers) {
        printNumbers("printAllLambda", numbers, System.out::println);
    }

    private static void printNumbers(String message, List<Integer> numbers, Consumer<Integer> write) {
        System.out.println(message);
        numbers.stream()
            .forEach(write);
    }

    public static void runThread() {
        new Thread(() -> System.out.println("Hello from thread")).start();
    }

    public static int sumAll(List<Integer> numbers) {
        return filteringSum(numbers, number -> Boolean.TRUE);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return filteringSum(numbers, number -> number % 2 == 0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return filteringSum(numbers, number -> number > 3);
    }

    private static int filteringSum(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
            .filter(predicate)
            .mapToInt(Integer::intValue)
            .sum();
    }
}
