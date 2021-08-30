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

    public static int sumAll(List<Integer> numbers, Expression expression) {
        int total = 0;
        for (Integer number : numbers) {
            total = getTotal(total, number, expression.sum(number));
        }
        return total;
    }

    public static int sumAllEven(List<Integer> numbers, Expression expression) {
        int total = 0;
        for (Integer number : numbers) {
            total = getTotal(total, number, expression.sum(number));
        }
        return total;
    }

    public static int sumAllOverThree(List<Integer> numbers, Expression expression) {
        int total = 0;
        for (Integer number : numbers) {
            total = getTotal(total, number, expression.sum(number));
        }
        return total;
    }

    private static int getTotal(int total, Integer number, boolean sum) {
        if (sum) {
            total += number;
        }
        return total;
    }
}
