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

    // 일반화된 sumAll 메서드
    public static int conditionalSum(List<Integer> numbers, Conditional condition) {
        int total = 0;
        for (int number : numbers) {
            if (condition.test(number)) {
                total += number;
            }
        }
        return total;
    }

    public static int sumAll(List<Integer> numbers) {
        return conditionalSum(numbers, x -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return conditionalSum(numbers, x -> x % 2 == 0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return conditionalSum(numbers, x -> x > 3);
    }

    public interface Conditional {

        boolean test(Integer number);
    }
}
