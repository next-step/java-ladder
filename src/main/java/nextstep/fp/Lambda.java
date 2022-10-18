package nextstep.fp;

import java.util.List;
import java.util.function.IntPredicate;

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

    public static int sumAllByCondition(List<Integer> numbers, IntPredicate condition) {
        return numbers.stream()
                .mapToInt(number -> number)
                .filter(condition)
                .sum();
    }

}
