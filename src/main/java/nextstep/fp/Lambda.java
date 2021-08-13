package nextstep.fp;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.stream.Collectors;

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

    public static int sumAll(List<Integer> numbers, Conditional conditional) {
        return numbers.stream()
                .filter(number -> conditional.test(number))
                .mapToInt(number -> number)
                .sum();
    }

    public static int sumAllEven(List<Integer> numbers) {
        Conditional conditional = number -> number % 2 == 0;

        return sumAll(numbers, conditional);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        Conditional conditional = number -> number > 3;

        return sumAll(numbers, conditional);
    }
}
