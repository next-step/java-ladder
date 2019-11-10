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
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from thread");
            }
        }).start();
    }

    public static int sum(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers
                .stream()
                .filter(predicate)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int sumAll(List<Integer> numbers) {
        return sum(numbers, (Predicate<Integer>) (number) -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        final Predicate<Integer> predicate = (number) -> number % 2 == 0;
        return sum(numbers, predicate);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        final Predicate<Integer> predicate = (number) -> number > 3;
        return sum(numbers, predicate);
    }

    public static int sum(List<Integer> numbers, Conditional conditional) {
        return numbers.stream().filter(number -> conditional.test(number)).mapToInt(Integer::intValue).sum();
    }
}
