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

    public static int sumAll(List<Integer> numbers) {
        return sumAllByCondition(numbers, number -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumAllByCondition(numbers, number -> number % 2 == 0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumAllByCondition(numbers, number -> number > 3);
    }

    private static int sumAllByCondition(List<Integer> numbers, Conditional conditional) {
        AtomicInteger total = new AtomicInteger(0);
        numbers.forEach(number -> {
            if (conditional.test(number)) {
                total.addAndGet(number);
            }
        });
        return total.get();
    }

}
