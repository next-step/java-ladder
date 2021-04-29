package nextstep.fp;

import java.util.List;

public class Lambda {
    public static void printAllOld(List<Integer> numbers) {
        System.out.println("printAllOld");
        numbers.forEach(number -> System.out.println(number));
    }

    public static void printAllLambda(List<Integer> numbers) {
        System.out.println("printAllLambda");
        numbers.forEach(System.out::println);
    }

    public static void runThread() {
        new Thread(() -> System.out.println("Hello from thread")).start();
    }

    public static int sumAll(List<Integer> numbers) {

        return sum(numbers, number -> true);
        /*return numbers.stream()
                .filter()
                .reduce(0, Integer::sum);*/
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sum(numbers, number -> number % 2 == 0);
        /*8return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);*/
    }

    public static int sumAllOverThree(List<Integer> numbers) {

        return sum(numbers, number -> number > 3);
        /*return numbers.stream()
                .filter(number -> number > 3)
                .reduce(0, Integer::sum);*/
    }

    private static int sum(List<Integer> numbers, Conditional conditional) {
        return numbers.stream().filter(conditional::isAllowAdd).reduce(0, Integer::sum);
    }
}
