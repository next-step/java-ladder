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

    public static int sumAll(List<Integer> numbers) {
        return sumWithStrategy(numbers, (x) -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumWithStrategy(numbers, (x) -> x % 2 == 0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumWithStrategy(numbers, (x) -> x > 3);
    }

    private static int sumWithStrategy(List<Integer> numbers, SumStrategy sumStrategy) {
        int total = 0;
        for (int number : numbers) {
            total = sum(total, number, sumStrategy);
        }
        return total;
    }

    private static int sum(int total, int number, SumStrategy sumStrategy) {
        if (sumStrategy.condition(number)) {
            return total + number;
        }
        return total;
    }

}
