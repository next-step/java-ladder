package nextstep.fp;

import java.util.List;

public class Lambda {
    public static void printAllOld(final List<Integer> numbers) {
        System.out.println("printAllOld");

        for (final int number : numbers) {
            System.out.println(number);
        }
    }

    public static void printAllLambda(final List<Integer> numbers) {
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

    public static int sum(final List<Integer> numbers, final Conditional predicate) {
        return numbers.stream()
            .filter(predicate::test)
            .reduce(0, Integer::sum);
    }

    public static int sumAll(final List<Integer> numbers) {
        int total = 0;
        for (final int number : numbers) {
            total += number;
        }
        return total;
    }

    public static int sumAllEven(final List<Integer> numbers) {
        int total = 0;
        for (final int number : numbers) {
            if (number % 2 == 0) {
                total += number;
            }
        }
        return total;
    }

    public static int sumAllOverThree(final List<Integer> numbers) {
        int total = 0;
        for (final int number : numbers) {
            if (number > 3) {
                total += number;
            }
        }
        return total;
    }
}
