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
        new Thread(() -> System.out.println("Hello from thread"))
                .start();
    }

    public static int sumAll(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public static int sumAllUsingReduce(List<Integer> numbers) {
        return numbers
                .stream()
                .reduce(0, (a, b) -> Integer.sum(a, b));
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumAllByCondition(numbers, i -> 0 == (i % 2));
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumAllByCondition(numbers, i -> (3 < i));
    }

    public static int sumAllByCondition(List<Integer> numbers, Conditional condition) {
        return numbers
                .stream()
                .filter(condition::meetCondition)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
