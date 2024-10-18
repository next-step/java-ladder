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

    public static int sum(Conditional conditional, List<Integer> numbers) {
        return numbers.stream()
                .filter(it -> conditional.test(it))
                .reduce(0, Integer::sum);
    }

    public static int sumAll(List<Integer> numbers) {
        return sum(number -> true, numbers);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sum(number -> number % 2 == 0, numbers);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sum(number -> number > 3, numbers);
    }
}
