package nextstep.fp;

import java.util.List;

public class Lambda {
    interface SumCondition {
        boolean test(Integer number);
    }

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

    private static int sumWithCondition(List<Integer> numbers, SumCondition condition) {
        return numbers.stream()
                .filter(n -> condition.test(n))
                .reduce(0, (subtotal, n) -> subtotal + n);
    }

    public static int sumAll(List<Integer> numbers) {
        return sumWithCondition(numbers, number -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumWithCondition(numbers, number -> number % 2 == 0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumWithCondition(numbers, number -> number > 3);
    }
}
