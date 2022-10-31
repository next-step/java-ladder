package nextstep.fp;

import java.util.List;
import java.util.function.Predicate;

public class Lambda {
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
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int sumAllEven(List<Integer> numbers) {
        Predicate<Integer> number = n -> n % 2 == 0;
        return sum(numbers, number);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        Predicate<Integer> number = n -> n > 3;
        return sum(numbers, number);
    }

    private static int sum(List<Integer> numbers, Predicate predicate) {
        return numbers.stream()
                .filter(predicate::test)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
