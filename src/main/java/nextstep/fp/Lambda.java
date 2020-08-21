package nextstep.fp;

import java.util.List;

public class Lambda {
    public static void printAllOld(List<Integer> numbers) {
        System.out.println("printAllOld");

        numbers.stream()
            .forEach(System.out::println);
    }

    public static void printAllLambda(List<Integer> numbers) {
        System.out.println("printAllLambda");

        numbers.stream()
            .forEach(System.out::println);
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
        return numbers.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    public static int sumAllEven(List<Integer> numbers) {
        return numbers.stream()
            .filter(number -> number % 2 == 0)
            .mapToInt(Integer::intValue)
            .sum();
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return numbers.stream()
            .filter(number-> number > 3)
            .mapToInt(Integer::intValue)
            .sum();
    }
}
