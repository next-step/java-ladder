package nextstep.fp;

import java.util.List;

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

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumConditional(numbers, number -> number > 3);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumConditional(numbers, number -> number % 2 == 0);
    }

    public static int sumAll(List<Integer> numbers) {
        return sumConditional(numbers, number -> true);
    }

    private static int sumConditional(List<Integer> numbers, Conditional sumConditional) {
        return numbers.stream()
                .filter(sumConditional::check)
                .mapToInt(Integer::intValue)
                .sum();
    }

}
