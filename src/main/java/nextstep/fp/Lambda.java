package nextstep.fp;

import java.util.List;

public class Lambda {
    private static final Integer INTEGER_ZERO = 0;

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
        return numbers.stream().reduce(INTEGER_ZERO, Integer::sum);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .reduce(INTEGER_ZERO, Integer::sum);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num > 3)
                .reduce(INTEGER_ZERO, Integer::sum);
    }
}
