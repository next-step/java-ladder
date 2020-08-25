package nextstep.fp;

import java.util.List;

public class Lambda {

    private static final int DIVIDING_VALUE = 2;
    private static final int NUMBER_ZERO = 0;
    private static final int NUMBER_THREE = 3;

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
        return sum(numbers, number -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sum(numbers, number -> (number % DIVIDING_VALUE == NUMBER_ZERO));
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sum(numbers, number -> (number > NUMBER_THREE));
    }

    private static int sum(List<Integer> number, Conditional conditional) {
        return number.stream()
                .filter(conditional::condition)
                .mapToInt(Integer::intValue)
                .sum();
    }

}
