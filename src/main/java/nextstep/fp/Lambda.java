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

    public static int sumAll(List<Integer> numbers) {
        return sumAll(numbers, n -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumAll(numbers, n -> n % 2 == 0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumAll(numbers, n -> n > 3);
    }

    public static int sumAll(List<Integer> numbers, Conditional condition) {
        return numbers.stream()
            .filter(condition::check)
            .mapToInt(Integer::intValue)
            .sum();
    }

}
