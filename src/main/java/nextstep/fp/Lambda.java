package nextstep.fp;

import java.util.List;

public class Lambda {
    public static void printByCondition(List<Integer> numbers, Conditional conditional) {
        numbers.stream()
                .filter(conditional::isCondition)
                .forEach(System.out::println);
    }

    public static void printAllOld(List<Integer> numbers) {
        System.out.println("printAllOld");

        printByCondition(numbers, Lambda::isOdd);
    }

    public static void printAllLambda(List<Integer> numbers) {
        System.out.println("printAllLambda");

        printByCondition(numbers, number -> true);
    }

    public static void runThread() {
        new Thread(() -> System.out.println("Hello from thread")).start();
    }

    public static int sumByCondition(List<Integer> numbers, Conditional conditional) {
        return numbers.stream()
                .filter(conditional::isCondition)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int sumAll(List<Integer> numbers) {
        return sumByCondition(numbers, number -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumByCondition(numbers, Lambda::isEven);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumByCondition(numbers, Lambda::isOverThree);
    }

    private static boolean isOdd(int number) {
        return number % 2 == 1;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static boolean isOverThree(int number) {
        return number > 3;
    }
}
