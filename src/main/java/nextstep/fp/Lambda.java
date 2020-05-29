package nextstep.fp;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

    public static int sumAll(List<Integer> numbers, Conditional conditional) {
        int total = 0;
        for (Integer number : numbers) {
            if (conditional.test(number)) {
                total += number;
            }
        }
        return total;
        //return numbers.stream().reduce(0, Integer::sum);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return numbers.stream().filter(number -> number % 2 == 0)
                .mapToInt(Integer::valueOf).sum();
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            if (number > 3) {
                total += number;
            }
        }
        return total;
    }
}
