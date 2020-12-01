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
        new Thread(() -> System.out.println("Hello from thread")).start();
    }

    public static int sumIf(List<Integer> numbers, Predicate<Integer> matched){
        return numbers.stream()
                .filter(matched)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static int sumAll(List<Integer> numbers) {
        return sumIf(numbers, it -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumIf(numbers, Lambda::isEven);
    }

    private static boolean isEven(Integer number) {
        return number % 2 == 0;
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumIf(numbers, Lambda::isGreaterThenThree);
    }

    private static boolean isGreaterThenThree(Integer number) {
        return number > 3;
    }
}
