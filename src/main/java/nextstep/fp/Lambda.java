package nextstep.fp;

import java.util.List;

public class Lambda {
    private static final int ZERO_NUMBER = 0;
    private static final int DIVIDE_NUMBER = 2;
    private static final int CONDITION_NUMBER = 3;

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
        return sumByConditional(numbers, number -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumByConditional(numbers, number -> (number % DIVIDE_NUMBER == ZERO_NUMBER));
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumByConditional(numbers, number -> (number > CONDITION_NUMBER));
    }

    public static int sumByConditional(List<Integer> numbers, Conditional conditional) {
        return numbers.stream()
                .filter(conditional::test)
                .reduce(ZERO_NUMBER, Integer::sum);
    }
}
