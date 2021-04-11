package nextstep.fp;

import java.util.List;
import java.util.stream.Collectors;

public class Lambda {
    private static final int FILTER_MIN_VALUE = 3;
    private static final int DOUBLE = 2;
    private static final int ZERO = 0;

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

    public static int sumAll(List<Integer> numbers, Conditional conditional) {
        return conditional.sum(numbers);
    }

    public static int sumAllEven(List<Integer> numbers, Conditional conditional) {
        return conditional.sum(numbers.stream().filter(number -> number % DOUBLE == ZERO).collect(Collectors.toList()));
    }

    public static int sumAllOverThree(List<Integer> numbers, Conditional conditional) {
        return conditional.sum(numbers.stream().filter(number -> number > FILTER_MIN_VALUE).collect(Collectors.toList()));
    }
}
