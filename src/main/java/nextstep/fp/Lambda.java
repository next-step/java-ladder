package nextstep.fp;

import java.util.List;

import static java.lang.System.out;

public class Lambda {
    public static void printAllOld(List<Integer> numbers) {
        out.println("printAllOld");
        numbers.stream()
                .forEach(out::println);
    }

    public static void printAllLambda(List<Integer> numbers) {
        out.println("printAllLambda");
        numbers.forEach(out::println);
    }

    public static void runThread() {
        new Thread(() -> System.out.println("Hello from thread"))
                .start();
    }

    public static int sum(List<Integer> numbers, Conditional conditional) {
        return numbers.stream()
                .filter(conditional::isMatch)
                .reduce(0, (num1, num2) -> num1 + num2);
    }

    public static int sumAll(List<Integer> numbers) {
        return sum(numbers, number -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sum(numbers, number -> number % 2 == 0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sum(numbers, number -> number > 3);
    }
}
