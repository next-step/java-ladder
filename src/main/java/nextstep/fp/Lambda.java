package nextstep.fp;

import java.util.List;
import java.util.function.IntPredicate;
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

    public static void runThread() {
        new Thread(() -> System.out.println("Hello from thread")).start();
    }

    public static int sumAll(List<Integer> numbers) {
        return sumIntegerList(numbers);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumIntegerList(numbers, iNumber -> iNumber % 2 == 0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumIntegerList(numbers, iNumber -> iNumber > 3);
    }

    private static int sumIntegerList(List<Integer> numbers) {
        return sumIntegerList(numbers, iNumber -> true);
    }

    private static int sumIntegerList(List<Integer> numbers, IntPredicate condition) {
        return numbers.stream()
                .mapToInt(iNumber -> iNumber)
                .filter(condition)
                .sum();
    }
}
