package nextstep.fp;

import java.util.List;

public class Lambda {
    private static final int START_VALUE = 0;
    private static final int EVEN_INDICATOR = 2;
    private static final int REMAINDER_ZERO = 0;
    private static final int SUM_OVER_BORDER = 3;

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
                .reduce(START_VALUE, Integer::sum);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % EVEN_INDICATOR == REMAINDER_ZERO)
                .reduce(START_VALUE, Integer::sum);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > SUM_OVER_BORDER)
                .reduce(START_VALUE, Integer::sum);
    }
}
