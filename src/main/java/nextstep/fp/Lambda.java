package nextstep.fp;

import java.util.List;
import java.util.stream.Stream;

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
        Stream<Integer> integerStream = numbers.stream();

        return commonSum(integerStream);
    }

    public static int sumAllEven(List<Integer> numbers) {
        Stream<Integer> integerStream = numbers.stream()
                .filter(number -> number % 2 == 0);
        return commonSum(integerStream);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        Stream<Integer> integerStream = numbers.stream()
                .filter(number -> number > 3);

        return commonSum(integerStream);
    }

    public static int commonSum(Stream<Integer> integerStream) {
        return integerStream
                .mapToInt(number -> number)
                .sum();
    }
}