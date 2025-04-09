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
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from thread");
            }
        }).start();
    }

    public static int sumAll(final List<Integer> numbers) {
        return Lambda.conditionalSum(numbers, i -> true);
    }

    public static int sumAllEven(final List<Integer> numbers) {
        return Lambda.conditionalSum(numbers, i -> i%2 == 0);
    }

    public static int sumAllOverThree(final List<Integer> numbers) {
        return Lambda.conditionalSum(numbers, i -> i > 3);
    }

    public static int conditionalSum(final List<Integer> numbers, final Conditional conditional) {
        int total = 0;
        for (int number : numbers) {
            if (conditional.test(number)) {
                total += number;
            }
        }
        return total;
    }
}
