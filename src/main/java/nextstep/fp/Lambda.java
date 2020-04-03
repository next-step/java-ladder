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

    public static int sumAll(List<Integer> numbers) {
        int total = 0;
        return numbers.stream().reduce(total, Integer::sum);
    }

    public static int sumAllEven(List<Integer> numbers) {
        int total = 0;
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(total, Integer::sum);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        int total = 0;
        return numbers.stream()
                .filter(number -> number > 3)
                .reduce(total, Integer::sum);
    }
}
