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

    public static int sumAll_old(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    private static int sum(int total, int number, SumStrategy sumStrategy) {
        if (sumStrategy.condition(number)) {
            return total + number;
        }
        return total;
    }

    public static int sumAll(List<Integer> numbers, SumStrategy sumStrategy) {
        int total = 0;
        for (int number : numbers) {
            total = sum(total, number, sumStrategy);
        }
        return total;
    }

    public static int sumAllEven(List<Integer> numbers, SumStrategy sumStrategy) {
        int total = 0;
        for (int number : numbers) {
            total = sum(total, number, sumStrategy);
        }
        return total;
    }

    public static int sumAllOverThree(List<Integer> numbers, SumStrategy sumStrategy) {
        int total = 0;
        for (int number : numbers) {
            total = sum(total, number, sumStrategy);
        }
        return total;
    }

    public static int sumAll2(List<Integer> numbers, SumStrategy2 sumStrategy) {
        int total = 0;
        for (int number : numbers) {
            total = sumStrategy.sum(total, number);
        }
        return total;
    }

    public static int sumAllEven2(List<Integer> numbers, SumStrategy2 sumStrategy) {
        int total = 0;
        for (int number : numbers) {
            total = sumStrategy.sum(total, number);
        }
        return total;
    }

    public static int sumAllOverThree2(List<Integer> numbers, SumStrategy2 sumStrategy) {
        int total = 0;
        for (int number : numbers) {
            total = sumStrategy.sum(total, number);
        }
        return total;
    }
}
